package com.hpeu.oa.service.impl;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hpeu.oa.dao.ResouceDao;
import com.hpeu.oa.entity.ResourceVO;
import com.hpeu.oa.entity.Resoure;
import com.hpeu.oa.service.ResourceService;
@Service
public class ResourceServiceImpl implements ResourceService{
	@Autowired
	private ResouceDao resouceDao;
	
	//添加文件
	public void add(Resoure entity) {
		resouceDao.add(entity);
	}

	public void delete(int id) {
		
	}

	public void update(Resoure entity) {
		
	}

	public Resoure select(int id) {
		return null;
	}

	public List<Resoure> getAll() {
		return null;
	}

	@Override
	public List<Resoure> getAll(RowBounds rowBounds) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getCount() {
		return resouceDao.getCount();
	}

	@Override
	public List<ResourceVO> findAll(RowBounds rowBounds) {
		return resouceDao.findAll();
	}


}
