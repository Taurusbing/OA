package com.hpeu.oa.service.impl;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
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
	public void delete(int id) {
		problemDao.delete(id);
	}

	@Override
	public void update(Problem entity) {
		problemDao.update(entity);
	}

	@Override
	public Problem select(int id) {
		return problemDao.getOne(id);
	}

	@Override
	public List<Problem> getAll() {
		return problemDao.getAll();
	}

	@Override
	public List<Problem> getAll(RowBounds rowBounds) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 0;
	}

}
