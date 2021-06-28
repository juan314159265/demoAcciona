package org.jpgp.tweetsrv.service.impl;

import java.util.List;
import java.util.Optional;

import org.jpgp.tweetsrv.domain.Hashtags;
import org.jpgp.tweetsrv.repository.HashtagsRepository;
import org.jpgp.tweetsrv.service.IConfig;
import org.jpgp.tweetsrv.service.IHashtagService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class HashtagsService implements IHashtagService {

	private static final Logger log = LoggerFactory.getLogger(HashtagsService.class);
	private HashtagsRepository hashtagRepository;
	private IConfig config;

	public HashtagsService(IConfig config, HashtagsRepository hashtagRepository) {
		this.config = config;
		this.hashtagRepository = hashtagRepository;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.jpgp.tweetsrv.service.IHashtagService#getHashtags(java.util.Optional)
	 */
	@Override
	public List<Hashtags> getHashtags(Optional<Integer> maxElements) {
		log.info("Start HashtagsService.getHashtags => maxElements=" + maxElements);
		Integer num = maxElements.orElse(config.getDefaultMaxHashtags());

		Sort sort = Sort.by("contador").descending();
		Pageable firstPageWithNumElements = PageRequest.of(0, num, sort);

		Page<Hashtags> res = hashtagRepository.findAll(firstPageWithNumElements);
		log.info("End HashtagsService.getHashtags => maxElements=" + maxElements + " res:"
				+ res.getContent().toString());
		return res.getContent();
	}

}
