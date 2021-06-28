package org.jpgp.tweetsrv.service;

import java.util.List;

public interface IConfig {

	Integer getNumUsersMinToPersist();

	Integer getDefaultMaxHashtags();

	List<String> getLanguagesToPersist();

}