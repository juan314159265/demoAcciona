package org.jpgp.tweetsrv.rest;

import java.util.List;

import org.jpgp.tweetsrv.domain.Tweet;
import org.jpgp.tweetsrv.service.ITweeterService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TweetsRest {

	private ITweeterService twService;

	public TweetsRest(ITweeterService twService) {
		this.twService = twService;

	}

	@GetMapping("/tweets")
	public List<Tweet> getTweets() {
		return twService.getTweets();
	}

	@GetMapping("/tweets.validate/{id}")
	public Tweet validateTweet(@PathVariable("id") Long id) {
		return twService.validate(id);
	}

	@GetMapping("/tweets.validates")
	public List<Tweet> getValidatesTweets() {
		return twService.getTweetsValidates();
	}

}
