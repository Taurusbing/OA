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
	
	/**
	 * 方法名：goData <br>
	 * 创建人：Taurus<br>
	 * 跳转到学生问题列表页
	 */
	@RequestMapping(value="/showpro",method=RequestMethod.GET)
	public String goData() {
		return "showpro";
	}
	
	/**
	 * 方法名：getAll <br>
	 * 创建人：Taurus<br>
	 * 展示问题列表
	 */
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
	
	/**
	 * 方法名：write <br>
	 * 创建人：Taurus<br>
	 * 解答问题功能
	 */
	@RequestMapping(value="/write",method=RequestMethod.GET)
	public String write(int proId,String content) {
		Problem problem = problemService.select(proId);
		problem.setAnswer(content);
		//传入助教admin的id
		problem.setAdmin_id(1);
		problem.setIs_finish(1);
		problemService.update(problem);
		return "showpro";
	}
	
	/**
	 * 删除数据
	 */
	@RequestMapping(value="/prodel",method=RequestMethod.POST)
	public void prodel(int id) {
		problemService.delete(id);
		System.out.println("删除成功");
	}
}
