package com.hpeu.oa.dao;

import java.util.List;

import com.hpeu.oa.entity.Problem;

public interface ProblemDao extends BaseDao1<Problem> {
	//获取所有
	List<Problem> getAll();
	
	//获取单个
	Problem getOne(int id);
	
	//修改数据
	void update(Problem entity);
	
	//删除
	void delete(int id);
}
