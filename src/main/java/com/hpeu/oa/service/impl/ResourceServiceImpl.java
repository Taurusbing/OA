package com.hpeu.oa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hpeu.oa.dao.ResouceDao;
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

	public void delete(Resoure entity) {
		
	}

	public void update(Resoure entity) {
		
	}

	public Resoure select(int id) {
		return null;
	}

	public List<Resoure> getAll() {
		return null;
	}

}
