package com.mini.program.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mini.program.entity.Consumer;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface ConsumerMapper extends BaseMapper<Consumer> {

    Consumer findConsumerById(Long id);

    Consumer findConsumerByWechatOpenid(String wechatOpenid);

    void insertConsumer(Consumer consumer);

    void updateConsumer(Consumer consumer);

}
