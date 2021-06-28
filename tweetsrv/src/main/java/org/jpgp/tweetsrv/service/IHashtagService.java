package org.jpgp.tweetsrv.service;

import java.util.List;
import java.util.Optional;

import org.jpgp.tweetsrv.domain.Hashtags;

public interface IHashtagService {

	List<Hashtags> getHashtags(Optional<Integer> maxElements);

}