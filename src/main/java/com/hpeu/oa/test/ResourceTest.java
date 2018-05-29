package com.hpeu.oa.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hpeu.oa.dao.ResouceDao;
import com.hpeu.oa.entity.Resoure;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:spring-mybatis.xml")
public class ResourceTest {
	@Autowired
	private ResouceDao resouceDao;
	
	@Test
	public void addResouce() {
		Resoure resoure = new Resoure();
//		resoure.setName("name");
		resoure.setUrl("D://");
		resouceDao.add(resoure);
		System.out.println("添加成功");
	}
	
}
