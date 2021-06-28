package org.jpgp.tweetsrv.service.impl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.jpgp.tweetsrv.domain.Configuration;
import org.jpgp.tweetsrv.domain.enums.ConfigNames;
import org.jpgp.tweetsrv.repository.ConfigurationRepository;
import org.jpgp.tweetsrv.service.IConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

@Service
public class Config implements IConfig {

	private static final Logger log = LoggerFactory.getLogger(Config.class);

	private static List<Configuration> configs = Arrays.asList(
			new Configuration().keyid(ConfigNames.NUM_USERS_MIN_TO_PERSIST.toString()).type("INTEGER")
					.description("Minimun number of of followers of user to persist tweet").value("1500"),

			new Configuration().keyid(ConfigNames.LANGUAGES_TO_PERSIST.toString()).type("LIST_STRING")
					.description("Language of tweet to persist tweet").value("es,fr,it"),

			new Configuration().keyid(ConfigNames.DEFAULT_MAX_HASHTAGS.toString()).type("INTEGER")
					.description("Max of list of hashtag by default").value("10")

	);

	private ConfigurationRepository repository;
	private Map<ConfigNames, Configuration> cache = null;

	public Config(ConfigurationRepository repository) {
		this.repository = repository;
		reset();

	}

	private void completeDataNotFound() {
		log.info("Init");
		for (Configuration config : configs) {

			Configuration exConfig = new org.jpgp.tweetsrv.domain.Configuration().keyid(config.getKeyid());
			Example<Configuration> example = Example.of(exConfig);

			// Specification<org.jpgp.tweetsrv.domain.Configuration> Example;
			long num = repository.count((org.springframework.data.domain.Example<Configuration>) example);
			log.info("Found " + config.getKeyid() + "->" + num);
			if (num == 0) {
				log.info("Insert " + config);
				repository.save(config);
			}
		}
		log.info("End Init");
	}

	private void reset() {
		cache = null;
		completeDataNotFound();
		List<Configuration> findAll = repository.findAll();
		cache = new HashMap<>();
		findAll.stream().forEach(cfg -> {
			ConfigNames name = ConfigNames.valueOf(cfg.getKeyid());
			if (name != null) {
				cache.put(name, cfg);
			}
		});
		log.debug("Cache set:" + cache.toString());
	}

	private Optional<Configuration> getData(ConfigNames name) {
		Optional<Configuration> res = Optional.empty();
		if (cache == null || cache.size() == 0) {
			reset();
		}

		res = Optional.ofNullable(cache.get(name));

		return res;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.jpgp.tweetsrv.service.impl.IConfig#getNumUsersMinToPersist()
	 */
	@Override
	public Integer getNumUsersMinToPersist() {
		Optional<Configuration> data = getData(ConfigNames.NUM_USERS_MIN_TO_PERSIST);
		if (data.isPresent())
			return Integer.parseInt(data.get().getValue(), 10);
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.jpgp.tweetsrv.service.impl.IConfig#getDefaultMaxHashtags()
	 */
	@Override
	public Integer getDefaultMaxHashtags() {
		Optional<Configuration> data = getData(ConfigNames.DEFAULT_MAX_HASHTAGS);
		if (data.isPresent())
			return Integer.parseInt(data.get().getValue(), 10);
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.jpgp.tweetsrv.service.impl.IConfig#getLanguagesToPersist()
	 */
	@Override
	public List<String> getLanguagesToPersist() {
		Optional<Configuration> data = getData(ConfigNames.LANGUAGES_TO_PERSIST);
		if (data.isPresent())
			return Arrays.asList(data.get().getValue().split(","));
		return null;
	}

}
