package com.mini.program.repository;

import com.mini.program.entity.Category;
import com.mini.program.entity.Product;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import java.util.List;

@RepositoryRestResource(path = "product",collectionResourceRel = "product")
public interface ProductRepository extends BaseJpaRepository<Product,Integer> {
    // http://localhost:8080/product/search/category?id=1
    @RestResource(path="category",rel="category")
    public List<Product> findByCategoryId(@Param("id") Integer id);

    // http://localhost:8080/product/search/name?name=p1
    @RestResource(path="name",rel="name")
    public List<Product> findByName(@Param("name") String name);

//    public List<Product> findByCategory(Category category);
}