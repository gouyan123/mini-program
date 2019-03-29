package com.mini.program.repository;

import com.mini.program.entity.Category;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import javax.persistence.criteria.CriteriaBuilder;

@RepositoryRestResource(path = "/category")
public interface CategoryRepository extends BaseJpaRepository<Category,Integer> {

}