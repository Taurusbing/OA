package com.hpeu.oa.controller;

import java.io.File;
import java.io.IOException;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.MultipartFilter;
import org.springframework.web.servlet.ModelAndView;

import com.hpeu.oa.entity.ResourceVO;
import com.hpeu.oa.entity.Resoure;
import com.hpeu.oa.entity.Score;
import com.hpeu.oa.service.ResourceService;
import com.hpeu.oa.service.impl.ResourceServiceImpl;

import net.sf.json.JSONObject;

@RequestMapping("assistant")
@Controller
public class FileController {
	@Autowired
	private ResourceService resourceService;
	
	/**
	 * 跳转到file.jsp页面
	 */
	@RequestMapping(value="showfile",method=RequestMethod.GET)
	public ModelAndView showfile() {
		return new ModelAndView("assistant/file");
	}
	
	/**
	 * 显示所有文件
	 */
	@RequestMapping(value="seefile",method=RequestMethod.POST,produces = "application/json;charset=utf-8")
	@ResponseBody
	public String seefile(HttpServletRequest request) {
		int page = Integer.parseInt(request.getParameter("page"));
		int limit = Integer.parseInt(request.getParameter("limit"));
		
		Map<String, Object> map = new HashMap<>();
		//分页查询
		List<ResourceVO> list = resourceService.findAll(new RowBounds((page - 1)*limit,limit));
		//获取总数
		int count = resourceService.getCount();
		
		map.put("code", 0);
 		map.put("msg", "");
 		map.put("count", count);
		map.put("data", list);
		JSONObject jsonObject = JSONObject.fromObject(map);
		System.out.println(jsonObject.toString());
		return jsonObject.toString();
	}
	
	@RequestMapping(value="/fileup",method=RequestMethod.POST)
	public void upload(MultipartFile file) {
		try {
			file.transferTo(new File("D:\\upload\\"+file.getOriginalFilename()));
			Resoure resoure = new Resoure();
			resoure.setName(file.getOriginalFilename());
			resoure.setUrl("D:\\upload\\"+file.getOriginalFilename());
			resourceService.add(resoure);
			System.out.println("文件上传成功");
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
