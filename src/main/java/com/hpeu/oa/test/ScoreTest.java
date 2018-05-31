package com.hpeu.oa.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hpeu.oa.dao.ScoreDao;
import com.hpeu.oa.entity.Score;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:spring-mybatis.xml")
public class ScoreTest {
	@Autowired
	private ScoreDao ScoreDao;
	
	@Test
	public void getAll() {
		List<Score> list = ScoreDao.getAll();
		for(Score li : list) {
			System.out.println(li);
		}
	}
	
	@Test
	public void getOne() {
		Score score = ScoreDao.select(1);
		System.out.println(score);
	}
	
	@Test
	public void update() {
		Score score = ScoreDao.select(1);
		score.setOne(50.0f);
		ScoreDao.update(score);
		System.out.println("修改成功");
	}
}
