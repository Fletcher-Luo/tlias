package com.example;

import com.example.mapper.EmpMapper;
import com.example.pojo.Dept;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.gson.GsonAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class TliasApplicationTests {

	@Autowired
	private ApplicationContext applicationContext;

//	@Autowired
//	private Dept dept;

	@Test
	void contextLoads() {
		GsonAutoConfiguration bean = applicationContext.getBean(GsonAutoConfiguration.class);
		System.out.println(bean);
	}

}
