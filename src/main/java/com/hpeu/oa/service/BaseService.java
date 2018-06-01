package com.hpeu.oa.service;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

public interface BaseService<T> {
	//添加
	void add(T entity);
	//删除
	void delete(int id);
	//修改
	void update(T entity);
    //查询单个
	T select(int id);
	//查询所有
	List<T> getAll();
	
	//分页查询
	List<T> getAll(RowBounds rowBounds);
	
	//获取总数
	int getCount();
}
