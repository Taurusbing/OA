package com.hpeu.oa.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hpeu.oa.dao.ProblemDao;
import com.hpeu.oa.entity.Problem;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:spring-mybatis.xml")
public class ProblemTest {
	@Autowired
	private ProblemDao problemDao;
	
	@Test
	public void getAll() {
		List<Problem> list = problemDao.getAll();
		for(Problem li : list) {
			System.out.println(li);
		}
	}
}
