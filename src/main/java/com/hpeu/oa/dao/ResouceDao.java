package com.hpeu.oa.dao;

import java.util.List;

import com.hpeu.oa.entity.ResourceVO;
import com.hpeu.oa.entity.Resoure;

public interface ResouceDao extends BaseDao1<Resoure>{
	void add(Resoure resoure);
	
	List<ResourceVO> findAll();
	
	//获取总数
	int getCount();
}
