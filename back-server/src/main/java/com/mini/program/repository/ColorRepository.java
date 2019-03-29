package com.mini.program.repository;

import com.mini.program.entity.Color;
import com.mini.program.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "/color")
public interface ColorRepository extends BaseJpaRepository<Color,Integer> {

}