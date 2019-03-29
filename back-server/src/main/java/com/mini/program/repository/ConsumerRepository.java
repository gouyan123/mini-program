package com.mini.program.repository;

import com.mini.program.entity.Consumer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "/consumer")
public interface ConsumerRepository extends JpaRepository<Consumer,Long> {
    Consumer findByWechatOpenid(String wechatOpenid);
}