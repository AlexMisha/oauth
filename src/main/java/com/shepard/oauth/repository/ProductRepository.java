package com.shepard.oauth.repository;

import com.shepard.oauth.entity.Product;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(path = "products", collectionResourceRel = "products", itemResourceRel = "product")
public interface ProductRepository extends CrudRepository<Product, Long>, JpaSpecificationExecutor<Product> {
}
