package com.hpeu.oa.entity;

import java.sql.Timestamp;

/**
 * 推送课程表实体
 */
public class Cou {
	//课程id
	private int id;
	//课程名
	private String courseName;
	//课程描述
	private String coment;
	//发布时间
	private String putDate;
	//发布人
	private String adminName;
	//课程资源
	private String resourceName;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getComent() {
		return coment;
	}
	public void setComent(String coment) {
		this.coment = coment;
	}
	public String getPutDate() {
		return putDate;
	}
	public void setPutDate(Timestamp putDate) {
		this.putDate = putDate.toString();
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getResourceName() {
		return resourceName;
	}
	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}
	@Override
	public String toString() {
		return "Cou [id=" + id + ", courseName=" + courseName + ", coment=" + coment + ", putDate=" + putDate
				+ ", adminName=" + adminName + ", resourceName=" + resourceName + "]";
	}
	
}
