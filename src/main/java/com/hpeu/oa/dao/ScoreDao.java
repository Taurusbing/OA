package com.hpeu.oa.dao;

import java.util.List;

import com.hpeu.oa.entity.Score;

public interface ScoreDao extends BaseDao1<Score>{
	// 添加
	void add(Score entity);

	// 删除
	void delete(int id);

	// 修改
	void update(Score entity);

	// 查询单个
	Score select(int id);

	// 查询所有
	List<Score> getAll();
}
