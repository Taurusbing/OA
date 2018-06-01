package com.hpeu.oa.service;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import com.hpeu.oa.entity.Course;

public interface CourseService extends BaseService<Course>{
	public int findId(String name);
}
