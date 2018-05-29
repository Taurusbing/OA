package com.hpeu.oa.service;

import java.util.List;

public interface BaseService<T> {
	//添加
	void add(T entity);
	//删除
	void delete(T entity);
	//修改
	void update(T entity);
    //查询单个
	T select(int id);
	//查询所有
	List<T> getAll();
}
