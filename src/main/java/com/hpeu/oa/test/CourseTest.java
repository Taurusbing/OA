package com.hpeu.oa.test;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hpeu.oa.dao.CourseDao;
import com.hpeu.oa.dao.ResouceDao;
import com.hpeu.oa.entity.Cou;
import com.hpeu.oa.entity.Course;
import com.hpeu.oa.entity.Resoure;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:spring-mybatis.xml")
public class CourseTest {
	@Autowired
	private ResouceDao ResouceDao;
	@Autowired
	private CourseDao courseDao;
	
	@Test
	public void add() {
		String name = "测试";
		
		Date date = new Date();
		System.out.println("new Date:"+date);
		String nowTime = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(date);
		System.out.println("format:"+nowTime);
		Timestamp time = Timestamp.valueOf(nowTime);
		
//		Cou course = new Cou();
//		course.setName(name);
//		course.setPutDate(time);
//		courseDao.add(course);
		System.out.println("添加成功");
	}
	
	
	@Test 
	public void findTime() {
		Timestamp time = courseDao.findTime("测试");
		System.out.println(time);
	}
	
	@Test
	public void getAll() {
		List<Course> list = courseDao.getAll();
/*		System.out.println(list);
		for(Course li : list) {
			System.out.println(li);
		}*/
		Iterator<Course> it = list.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
}
