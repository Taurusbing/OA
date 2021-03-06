package com.hpeu.oa.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hpeu.oa.entity.Score;
import com.hpeu.oa.service.impl.ScoreServiceImpl;

import net.sf.json.JSONObject;

@RequestMapping("assistant")
@Controller 
public class ScoreController {
	@Autowired
	private ScoreServiceImpl scoreServiceImpl;
	
	/**
	 *跳转到score.jsp主页面
	 */
	@RequestMapping(value="score",method=RequestMethod.GET)
	public ModelAndView goScore() {
		return new ModelAndView("assistant/score");
	}
	
	/**
	 * 页面显示所有学生成绩
	 */
	@RequestMapping(value="showScore",method=RequestMethod.POST,produces = "application/json;charset=utf-8")
	@ResponseBody
	public String getAll(HttpServletRequest request) {
		int page = Integer.parseInt(request.getParameter("page"));
		int limit = Integer.parseInt(request.getParameter("limit"));
		
		Map<String, Object> map = new HashMap<>();
		//分页查询
		List<Score> list = scoreServiceImpl.getAll(new RowBounds((page - 1)*limit,limit));
		//获取总数
		int count = scoreServiceImpl.getCount();
		
		map.put("code", 0);
 		map.put("msg", "");
 		map.put("count", count);
		map.put("data", list);
		JSONObject jsonObject = JSONObject.fromObject(map);
		System.out.println(jsonObject.toString());
		return jsonObject.toString();
	}
	
	/**
	 * 添加学生成绩
	 * score是学生成绩，type是对应阶段 1：第一阶段 2：第二阶段  ，id是学生的id
	 */
	@RequestMapping(value="scorein",method=RequestMethod.POST)
	public void scorein(float score,int type,int id) {
		System.out.println(id);
		Score sc = scoreServiceImpl.select(id);
		if(type == 1) {
			sc.setOne(score);
		}
		if(type == 2) {
			sc.setTwo(score);
		}
		if(type == 3) {
			sc.setThree(score);
		}
		scoreServiceImpl.update(sc);
		System.out.println("添加第"+type+"阶段成功");
	}
}
