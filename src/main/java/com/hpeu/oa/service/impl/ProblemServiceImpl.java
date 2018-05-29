package com.hpeu.oa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hpeu.oa.dao.ProblemDao;
import com.hpeu.oa.entity.Problem;
import com.hpeu.oa.service.ProblemService;
@Service
public class ProblemServiceImpl implements ProblemService{
	@Autowired
	private ProblemDao problemDao;
	
	@Override
	public void add(Problem entity) {
		
	}

	@Override
	public void delete(Problem entity) {
		
	}

	@Override
	public void update(Problem entity) {
		
	}

	@Override
	public Problem select(int id) {
		return null;
	}

	@Override
	public List<Problem> getAll() {
		return problemDao.getAll();
	}

}
