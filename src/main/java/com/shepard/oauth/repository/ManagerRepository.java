package com.shepard.oauth.repository;

import com.shepard.oauth.entity.Manager;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(path = "managers", collectionResourceRel = "managers", itemResourceRel = "manager")
public interface ManagerRepository extends CrudRepository<Manager, Long>, JpaSpecificationExecutor<Manager> {

}
