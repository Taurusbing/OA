package com.hpeu.oa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hpeu.oa.dao.ScoreDao;
import com.hpeu.oa.entity.Score;
import com.hpeu.oa.service.BaseService;
@Service
public class ScoreServiceImpl implements BaseService<Score>{
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
	
}
