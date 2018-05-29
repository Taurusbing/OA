package com.hpeu.oa.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hpeu.oa.entity.Problem;
import com.hpeu.oa.service.ProblemService;

import net.sf.json.JSONObject;

@RequestMapping("course")
@Controller
public class ProblemController {
	@Autowired
	private ProblemService problemService;
	
	@RequestMapping(value="/showpro",method=RequestMethod.GET)
	public String goData() {
		return "showpro";
	}
	
	@RequestMapping(value="/problem",method=RequestMethod.POST,produces = "application/json;charset=utf-8" )
	@ResponseBody
	public String getAll() {
		Map<String, Object> map = new HashMap<>();
		List<Problem> list = problemService.getAll();
		map.put("code", 0);
		map.put("msg", "");
		map.put("count", list.size());
		map.put("data", list);
		JSONObject jsonObject = JSONObject.fromObject(map);
		System.out.println(jsonObject.toString());
		return jsonObject.toString();
	}
}
