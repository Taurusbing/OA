package com.hpeu.oa.dao;

import java.util.List;

import com.hpeu.oa.entity.Problem;

public interface ProblemDao extends BaseDao1<Problem> {
	List<Problem> getAll();
}
