package com.hpeu.oa.dao;

import java.sql.Timestamp;
import java.util.List;

import com.hpeu.oa.entity.Course;


public interface CourseDao extends BaseDao1<Course>{
	void add(Course entity);
	Course findOne(String name);
	Timestamp findTime(String name);
	List<Course> getAll();
}
