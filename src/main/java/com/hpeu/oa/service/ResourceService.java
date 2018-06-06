package com.hpeu.oa.service;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import com.hpeu.oa.entity.ResourceVO;
import com.hpeu.oa.entity.Resoure;

public interface ResourceService extends BaseService<Resoure>{
	public List<ResourceVO> findAll(RowBounds rowBounds);
	
}
