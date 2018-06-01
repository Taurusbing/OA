package com.hpeu.oa.dao;

import java.sql.Timestamp;
import java.util.List;

import org.apache.ibatis.session.RowBounds;

import com.hpeu.oa.entity.Course;


public interface CourseDao extends BaseDao1<Course>{
	//添加
	void add(Course entity);
	//查询单个
	Course findOne(String name);
	
	Timestamp findTime(String name);
	//查询所有
	List<Course> getAll(RowBounds rowBounds);
	//删除
	void delete(int id);
	
	int getCount() ;
}
