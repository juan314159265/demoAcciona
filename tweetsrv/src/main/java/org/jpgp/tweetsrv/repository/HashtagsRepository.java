package org.jpgp.tweetsrv.repository;

import java.util.*;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.jpgp.tweetsrv.domain.Configuration;
import org.jpgp.tweetsrv.domain.Hashtags;

/**
 * Spring Data repository for the Configuration entity.
 */
@SuppressWarnings("unused")
@RepositoryRestResource(collectionResourceRel = "crud.hashtags", path = "crud.hashtags")
public interface HashtagsRepository extends JpaRepository<Hashtags, Long>, QueryByExampleExecutor<Hashtags>,
		JpaSpecificationExecutor<Hashtags>, PagingAndSortingRepository<Hashtags, Long> {

}
