package com.hpeu.oa.dao;

import java.util.List;

import com.hpeu.oa.entity.ResourceVO;
import com.hpeu.oa.entity.Resoure;

public interface ResouceDao extends BaseDao1<Resoure>{
	void add(Resoure resoure);
	
	List<ResourceVO> findAll();
	
	//获取总数
	int getCount();
	
	//删除课程文件
	void delCourse(int cid);
	
	//删除
	void delete(int id);
}
