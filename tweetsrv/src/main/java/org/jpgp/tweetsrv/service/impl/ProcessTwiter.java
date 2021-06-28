package org.jpgp.tweetsrv.service.impl;

import java.util.Date;
import java.util.Optional;

import org.jpgp.tweetsrv.config.InitConfig;
import org.jpgp.tweetsrv.domain.Hashtags;
import org.jpgp.tweetsrv.domain.Tweet;
import org.jpgp.tweetsrv.repository.HashtagsRepository;
import org.jpgp.tweetsrv.repository.TweetRepository;
import org.jpgp.tweetsrv.service.IConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import twitter4j.GeoLocation;
import twitter4j.HashtagEntity;
import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;
import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationBuilder;

@Service
@Profile("!test")
public class ProcessTwiter implements StatusListener {

	private static final Logger log = LoggerFactory.getLogger(ProcessTwiter.class);

	private IConfig config;
	private InitConfig init;
	private PlatformTransactionManager transactionManager;

	private TwitterStream twitterStream;

	private Twitter twitter;

	private TweetRepository tweetRepository;

	private HashtagsRepository hashtagsRepository;

	public ProcessTwiter(IConfig config, InitConfig init, TweetRepository tweetRepository,
			HashtagsRepository hashtagsRepository, PlatformTransactionManager transactionManager) {
		this.init = init;
		this.tweetRepository = tweetRepository;
		this.hashtagsRepository = hashtagsRepository;
		this.transactionManager = transactionManager;
		this.config = config;

		log.info("Initialize twitter");
		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true).setOAuthConsumerKey(this.init.getConsumerKey())
				.setOAuthConsumerSecret(this.init.getConsumerSecret()).setOAuthAccessToken(this.init.getAccessToken())
				.setOAuthAccessTokenSecret(this.init.getAccessTokenSecret());
		Configuration build = cb.build();
		TwitterFactory tf = new TwitterFactory(build);
		twitter = tf.getInstance();
		twitterStream = new TwitterStreamFactory(build).getInstance();
		twitterStream.addListener(this);
		twitterStream.sample();
		try {
			twitter.updateStatus("Initialized app" + new Date());
		} catch (TwitterException e) {
			log.error("Error sending twitter:" + e.toString());
			e.printStackTrace();
		}

		log.info("End Initialize twitter");
	}

	// Listener method
	@Override
	public void onStatus(Status status) {
		log.info("Received Tweeter Status:" + status.toString());
		if (status.getUser().getFollowersCount() >= config.getNumUsersMinToPersist()) {
			if (config.getLanguagesToPersist().contains(status.getLang())) {
				log.info("Insert Tweeter Status:" + status.toString());
				DefaultTransactionDefinition definition = new DefaultTransactionDefinition();
				TransactionStatus transaction = transactionManager.getTransaction(definition);
				try {

					insertTweetFromStatus(status);
					insertHashtagsFromStatus(status);
					transactionManager.commit(transaction);
					log.info("=>Tweet inserted<=");
				} catch (Throwable t) {
					transactionManager.rollback(transaction);
					log.error("Error Insert Tweet:" + t.toString());
				}
				log.info("End Tweeter Status:" + status.toString());
			}
		}
	}

	// Listener method
	@Override
	public void onException(Exception ex) {

	}

	// Listener method
	@Override
	public void onDeletionNotice(StatusDeletionNotice statusDeletionNotice) {

	}

	// Listener method
	@Override
	public void onTrackLimitationNotice(int numberOfLimitedStatuses) {

	}

	// Listener method
	@Override
	public void onScrubGeo(long userId, long upToStatusId) {

	}

	// Listener method
	@Override
	public void onStallWarning(StallWarning warning) {

	}

	private Tweet insertTweetFromStatus(Status status) {
		log.info("Start TweetsService.insertTweetFromStatus => status=" + status.toString());
		Tweet tweet = new Tweet();

		tweet.setTexto(status.getText());
		tweet.setUsuario(status.getUser().getName());
		tweet.setValidacion(false);
		GeoLocation geoLocation = status.getGeoLocation();
		if (geoLocation != null) {
			tweet.setLocalizacionLatitud(Double.toString(geoLocation.getLatitude()));
			tweet.setLocalizacionLongitud(Double.toString(geoLocation.getLongitude()));
		}
		Tweet res = tweetRepository.save(tweet);
		log.info("End TweetsService.insertTweetFromStatus => status=" + status.toString() + " res:" + res.toString());
		return res;
	}

	private void insertHashtagsFromStatus(Status status) {
		log.info("Start HashtagsService.insertHashtags => status=" + status.toString());
		HashtagEntity[] entities = status.getHashtagEntities();
		for (HashtagEntity hashtag : entities) {
			Example<Hashtags> exHashtag = Example.of(new Hashtags().setHashtag(hashtag.getText()));

			Optional<Hashtags> opt = hashtagsRepository.findOne(exHashtag);
			if (opt.isPresent()) {
				Hashtags hashtags = opt.get();
				hashtags.setContador(hashtags.getContador() + 1);
				hashtagsRepository.save(hashtags);
			} else {
				Hashtags hashtags = new Hashtags().setHashtag(hashtag.getText()).setContador(1L);
				hashtagsRepository.save(hashtags);
			}
		}
		log.info("End HashtagsService.insertHashtags => status=" + status.toString());

	}
}
