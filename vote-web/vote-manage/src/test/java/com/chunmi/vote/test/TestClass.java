package com.chunmi.vote.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.chunmi.vote.Application;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringJUnit4ClassRunner.class) //使用junit4进行测试
@SpringBootTest(classes=Application.class)
@Slf4j
public class TestClass {

	/**
	 * 单元测试
	 */
	@Test
	public void test() {
		try {
			
		} catch (Exception e) {
			log.error(e.getMessage());
		}
	}
}
