package org.jpgp.tweetsrv.service;

import java.util.List;

import org.jpgp.tweetsrv.domain.Tweet;

public interface ITweeterService {

	List<Tweet> getTweets();

	Tweet validate(Long id);

	List<Tweet> getTweetsValidates();

}