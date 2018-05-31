package com.hpeu.oa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hpeu.oa.dao.CourseDao;
import com.hpeu.oa.entity.Course;
import com.hpeu.oa.service.CourseService;
@Service
public class CourseServiceImpl implements CourseService{
	@Autowired
	private CourseDao CourseDao;

	@Override
	public void add(Course entity) {
		CourseDao.add(entity);
	}

	@Override
	public void delete(int id) {
		CourseDao.delete(id);
	}

	@Override
	public void update(Course entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Course select(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Course> getAll() {
		return CourseDao.getAll();
	}

	@Override
	public int findId(String name) {
		return CourseDao.findOne(name).getId();
	}

}
