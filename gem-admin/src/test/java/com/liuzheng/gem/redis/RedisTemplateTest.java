package com.liuzheng.gem.redis;

import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.data.redis.core.RedisTemplate;

import com.liuzheng.gem.test.BaseTest;

public class RedisTemplateTest extends BaseTest {

	@Resource(name = "redisTemplate", type = RedisTemplate.class)
	private RedisTemplate<String, Object> template;

	@Test
	public void get() {

		template.opsForValue().set("name", "aaa", 10, TimeUnit.SECONDS);
		System.out.println(template.opsForValue().get("name"));
	}

	@Test
	public void delete() {

		template.delete("getImage,/2012/11/07/21230137890955069873.jpg");
	}
}
