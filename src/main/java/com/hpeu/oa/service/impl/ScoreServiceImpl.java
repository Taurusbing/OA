package com.hpeu.oa.service.impl;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hpeu.oa.dao.ScoreDao;
import com.hpeu.oa.entity.Score;
import com.hpeu.oa.service.ScoreService;
@Service
public class ScoreServiceImpl implements ScoreService{
	@Autowired
	private ScoreDao scoreDao;	
	
	@Override
	public void add(Score entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Score entity) {
		scoreDao.update(entity);
	}

	@Override
	public Score select(int id) {
		return scoreDao.select(id);
	}
	
	
	@Override
	public List<Score> getAll() {
		return scoreDao.getAll();
	}

	@Override
	public List<Score> getAll(RowBounds rowBounds) {
		return scoreDao.getAll(rowBounds);
	}

	@Override
	public int getCount() {
		return scoreDao.getCount();
	}

	
}
