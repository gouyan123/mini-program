package com.mini.program.repository;

import com.mini.program.entity.Product;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import java.util.List;

@RepositoryRestResource(path = "product",collectionResourceRel = "product")
public interface ProductRepository extends BaseJpaRepository<Product,Integer> {
    @RestResource(path="name",rel="name")
    public List<Product> findByName(@Param("name") String name);
}