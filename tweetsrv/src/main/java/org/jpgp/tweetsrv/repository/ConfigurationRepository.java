package org.jpgp.tweetsrv.repository;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.jpgp.tweetsrv.domain.Configuration;

/**
 * Spring Data repository for the Configuration entity.
 */
@SuppressWarnings("unused")
@RepositoryRestResource(collectionResourceRel = "crud.config", path = "crud.config")
public interface ConfigurationRepository
		extends JpaRepository<Configuration, Long>, QueryByExampleExecutor<Configuration>,
		JpaSpecificationExecutor<Configuration>, PagingAndSortingRepository<Configuration, Long> {

}
