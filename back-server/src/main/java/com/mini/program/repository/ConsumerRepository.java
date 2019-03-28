package com.mini.program.repository;

import com.mini.program.entity.Consumer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsumerRepository extends JpaRepository<Consumer,Long> {
    Consumer findByWechatOpenid(String wechatOpenid);
}