package com.mini.program.repository;

import com.mini.program.entity.Color;
import com.mini.program.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource(path = "/color")
public interface ColorRepository extends BaseJpaRepository<Color,Integer> {
    @RestResource(path = "name")
    List<Color> findByName(@Param("name") String name);

    @RestResource(path = "status")
    List<Color> findByStatus(@Param("status") Integer status);
}