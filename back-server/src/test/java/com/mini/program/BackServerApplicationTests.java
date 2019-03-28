package com.mini.program;

import com.mini.program.dao.ConsumerMapper;
import com.mini.program.entity.Consumer;
import com.mini.program.module.user.entity.User;
import com.mini.program.module.user.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BackServerApplicationTests.class)
public class BackServerApplicationTests {
	@Autowired
    private UserMapper mapper;

	private User user = new User();


	@Test
	public void contextLoads() {
		user.setName("James");
		int result = mapper.insert(user);
        System.out.println(result);
	}

}
