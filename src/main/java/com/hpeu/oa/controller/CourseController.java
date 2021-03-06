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
import org.apache.ibatis.session.RowBounds;
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

@RequestMapping("assistant")  
@Controller  
public class CourseController {
	@Autowired
	private ResourceService ResourceService;
	
	@Autowired
	private CourseService courseService;
	
	/**
	 *跳转到home.jsp主页面
	 */
	@RequestMapping(value="home",method=RequestMethod.GET)
	public String goHome() {
		return "assistant/home";
	}
	
	/**
	 *跳转到main.jsp主页面，显示控制面板页面
	 */
	@RequestMapping(value="main",method=RequestMethod.GET)
	public String goMain() {
		return "assistant/main";
	}
	
	/**
	 *跳转到课程推送页面
	 */
	@RequestMapping(value="add",method=RequestMethod.GET)
	public String goAdd() {
		return "assistant/courseAdd";
	}
	
	
	/**
	 *跳转到课程展示页面showdata.jsp
	 */
	@RequestMapping(value="showdata",method=RequestMethod.GET)
	public String goData() {
		return "assistant/showdata";
	}
	
	
    /**  
     * 文件上传功能,上传后将文件名存入session中
     */  
    @RequestMapping(value="/upload",method=RequestMethod.POST)  
    @ResponseBody  
    public void upload(MultipartFile file,HttpServletRequest request,HttpServletResponse response) throws IOException{  
    	if(file != null) {
    		request.getSession().setAttribute("sefile", file.getOriginalFilename());
    		file.transferTo(new File("D:\\upload\\"+file.getOriginalFilename()));
    	}
    }  
    
    
    
    /**
     * 课程上传功能
     */
    @RequestMapping(value="/putCourse",method=RequestMethod.GET)
    public String courseadd(Course course,HttpServletRequest request){ 
    	//从session中获取用户的id,需要时打开
//    	int adminId = (int) request.getSession().getAttribute("");
//    	course.setAdminId(adminId);
    	
    	//获取session中存储的文件名
    	String filename = (String) request.getSession().getAttribute("sefile");
    	//取出session里的东西后，将session清空
    	request.getSession().setAttribute("sefile", null);
    	
	    //推送时间
		Date date = new Date();
		String nowTime = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(date);
		Timestamp time = Timestamp.valueOf(nowTime);
		course.setPutDate(time);
		
		//添加课程到course表中
		courseService.add(course);
		
		//获取课程id
        int courseId = courseService.findId(course.getCourseName());
		
        //将文件资源，地址存入到resource表中
        Resoure resoure = new Resoure();
        if(filename != null) {
        	resoure.setName(filename);
        	resoure.setUrl("D:\\upload\\"+filename);
        	resoure.setCourseId(courseId);
        	ResourceService.add(resoure);
        }else {
        	resoure.setName("无文件");
        	resoure.setUrl(null);
        	resoure.setCourseId(courseId);
        	ResourceService.add(resoure);
        }
    	
    	System.out.println("推送成功");
    	return "redirect:/assistant/showdata";
    }
    
    
    
    /**
     * 将课程列表传给前台展示
     * 用于返回的数据字符处理produces = "application/json;charset=utf-8"
     */
	@RequestMapping(value="/show",method=RequestMethod.POST,produces = "application/json;charset=utf-8")
	@ResponseBody
	public String show(HttpServletRequest request) {
		int page = Integer.parseInt(request.getParameter("page"));
		int limit = Integer.parseInt(request.getParameter("limit"));
		Map<String, Object> map = new HashMap<>();
		//分页查询
		List<Course> list = courseService.getAll(new RowBounds((page -1)*limit, limit));
		//获取总数
		int count = courseService.getCount();
		
 		map.put("code", 0);
 		map.put("msg", "");
 		map.put("count", count);
		map.put("data", list);
		JSONObject jsonObject = JSONObject.fromObject(map);
		System.out.println(jsonObject.toString());
		return jsonObject.toString();
	}
	
	
	
	/**
	 * 删除课程
	 */
	@RequestMapping(value="/coursedel",method=RequestMethod.POST)
	public void delete(int cid) {
		courseService.delete(cid);
		ResourceService.delCourse(cid);
		System.out.println("删除成功");
	}
}
