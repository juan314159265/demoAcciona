package org.jpgp.tweetsrv.service.impl;

import java.util.List;
import java.util.Optional;

import org.jpgp.tweetsrv.domain.Tweet;
import org.jpgp.tweetsrv.repository.TweetRepository;
import org.jpgp.tweetsrv.service.ITweeterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TweetsService implements ITweeterService {

	private TweetRepository tweetRepository;

	private static final Logger log = LoggerFactory.getLogger(TweetsService.class);

	public TweetsService(TweetRepository tweetRepository) {
		this.tweetRepository = tweetRepository;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.jpgp.tweetsrv.service.ITweeterService#getTweets()
	 */
	@Override
	public List<Tweet> getTweets() {
		log.info("Start TweetsService.getTweets => ");
		List<Tweet> res = tweetRepository.findAll();
		log.info("End TweetsService.getTweets => res:" + res.toString());
		return res;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.jpgp.tweetsrv.service.ITweeterService#validate(java.lang.Long)
	 */
	@Override
	@Transactional
	public Tweet validate(Long id) {
		log.info("Start TweetsService.validate => id:" + id);
		Tweet res = null;
		Optional<Tweet> findById = tweetRepository.findById(id);
		if (findById.isPresent()) {
			Tweet tweet = findById.get();
			tweet.setValidacion(true);
			tweetRepository.save(tweet);
			res = tweet;
		}

		log.info("End TweetsService.validate => id:" + id + " res:" + ((res != null) ? res.toString() : "NULL"));
		return res;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.jpgp.tweetsrv.service.ITweeterService#getTweetsValidates()
	 */
	@Override
	public List<Tweet> getTweetsValidates() {
		log.info("Start TweetsService.getTweetsValidates => ");
		Example<Tweet> validTweetsExample = Example.of(new Tweet().validacion(true));
		List<Tweet> res = tweetRepository.findAll(validTweetsExample);
		log.info("End TweetsService.getTweetsValidates => res:" + res.toString());
		return res;
	}

}
