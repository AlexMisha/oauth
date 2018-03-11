package com.shepard.oauth.repository;

import com.shepard.oauth.entity.Manager;
import com.shepard.oauth.entity.ManagerPassword;
import com.shepard.oauth.entity.ManagerPassword_;
import com.shepard.oauth.entity.Manager_;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.Join;
import java.util.List;

@Repository
@RepositoryRestResource(exported = false)
public interface ManagerPasswordRepository extends CrudRepository<ManagerPassword, Long>,
        JpaSpecificationExecutor<ManagerPassword> {

    default List<ManagerPassword> findByUsername(String username) {
        return findAll((root, query, cb) -> {
            final Join<ManagerPassword, Manager> account = root.join(ManagerPassword_.manager);
            return cb.equal(account.get(Manager_.login), username);
        });
    }
}
