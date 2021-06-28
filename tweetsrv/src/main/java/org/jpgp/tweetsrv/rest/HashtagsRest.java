package org.jpgp.tweetsrv.rest;

import java.util.List;
import java.util.Optional;

import org.jpgp.tweetsrv.domain.Hashtags;
import org.jpgp.tweetsrv.service.IHashtagService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HashtagsRest {

	private IHashtagService htService;

	public HashtagsRest(

			IHashtagService htService) {

		this.htService = htService;

	}

	@RequestMapping(value = { "/hashtags", "/hashtags/{maxElements}" })
	public List<Hashtags> getListHashtags(@PathVariable Optional<Integer> maxElements) {

		return htService.getHashtags(maxElements);
	}

}
