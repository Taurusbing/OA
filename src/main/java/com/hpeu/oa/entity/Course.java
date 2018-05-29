package com.hpeu.oa.entity;

import java.sql.Timestamp;

public class Course {
	private int id;
	private int adminId;
	private String courseName;
	private String coment;
	private Timestamp putDate;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
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
	public Timestamp getPutDate() {
		return putDate;
	}
	public void setPutDate(Timestamp putDate) {
		this.putDate = putDate;
	}
	@Override
	public String toString() {
		return "CourseVO [id=" + id + ", adminId=" + adminId + ", courseName=" + courseName + ", coment=" + coment
				+ ", putDate=" + putDate + "]";
	}
	
}
