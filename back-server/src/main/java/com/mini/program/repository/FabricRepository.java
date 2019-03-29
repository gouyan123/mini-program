package com.mini.program.repository;

import com.mini.program.entity.Fabric;
import com.mini.program.entity.Product;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "/fabric")
public interface FabricRepository extends BaseJpaRepository<Fabric,Integer> {

}