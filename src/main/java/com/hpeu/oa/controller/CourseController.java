package com.hpeu.oa.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.hpeu.oa.dao.CourseDao;
import com.hpeu.oa.dao.ResouceDao;
import com.hpeu.oa.entity.Cou;
import com.hpeu.oa.entity.Course;
import com.hpeu.oa.entity.Resoure;
import com.hpeu.oa.service.CourseService;
import com.hpeu.oa.service.ResourceService;

import net.sf.json.JSONObject;

@RequestMapping("course")  
@Controller  
public class CourseController {
	@Autowired
	private ResourceService ResourceService;
	
	@Autowired
	private CourseService courseService;
	
	@RequestMapping(value="home",method=RequestMethod.GET)
	public String goHome() {
		return "home";
	}
	
	@RequestMapping(value="add",method=RequestMethod.GET)
	public String goAdd() {
		return "courseAdd";
	}
	
	@RequestMapping(value="showdata",method=RequestMethod.GET)
	public String goData() {
		return "showdata";
	}
    /**  
     * 文件上传功能    
     */  
    @RequestMapping(value="/upload",method=RequestMethod.POST)  
    @ResponseBody  
    public void upload(MultipartFile file,HttpServletRequest request,HttpServletResponse response) throws IOException{  
    	request.getSession().setAttribute("sefile", file.getOriginalFilename());
    	file.transferTo(new File("D:\\upload\\"+file.getOriginalFilename()));
    }  
    
    @RequestMapping(value="/putCourse",method=RequestMethod.GET)
    @ResponseBody
    public void course(Course course,HttpServletRequest request,HttpServletResponse response){  
	    String filename = (String) request.getSession().getAttribute("sefile");
	    System.out.println(filename);
    	
	    //推送时间
		Date date = new Date();
		String nowTime = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(date);
		Timestamp time = Timestamp.valueOf(nowTime);
		course.setPutDate(time);
		courseService.add(course);
		
		//获取课程id
        int courseId = courseService.findId(course.getCourseName());
		
    	Resoure resoure = new Resoure();
    	resoure.setName(filename);
    	resoure.setUrl("D:\\upload\\"+filename);
    	resoure.setCourseId(courseId);
    	ResourceService.add(resoure);
    	System.out.println("推送成功");
    }
    
	@RequestMapping(value="/show",method=RequestMethod.POST,produces = "application/json;charset=utf-8")
	@ResponseBody
	public String show() {
		Map<String, Object> map = new HashMap<>();
		List<Course> list = courseService.getAll();

 		map.put("code", 0);
 		map.put("msg", "");
 		map.put("count", list.size());
		map.put("data", list);
		JSONObject jsonObject = JSONObject.fromObject(map);
		System.out.println(jsonObject.toString());
		return jsonObject.toString();
	}
}
