package com.mini.program.dao;

import com.mini.program.entity.Consumer;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ConsumerMapper {

    Consumer findConsumerById(Long id);

    Consumer findConsumerByWechatOpenid(String wechatOpenid);

    void insertConsumer(Consumer consumer);

    void updateConsumer(Consumer consumer);

}
