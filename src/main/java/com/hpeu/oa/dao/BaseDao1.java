package com.hpeu.oa.dao;

import java.util.List;


public interface BaseDao1<T> {
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
}
