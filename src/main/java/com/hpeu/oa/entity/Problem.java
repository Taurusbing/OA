package com.hpeu.oa.entity;

import java.sql.Timestamp;

public class Problem {
	private int id;
	private String name;
	private String content;
	private String answer;
	private Timestamp queDate;
	private int adminId;
	private int studentId;
	private int isFinish;
	private String studentName;
	private String adminName;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getQue_date() {
		return queDate.toString();
	}
	public void setQue_date(Timestamp queDate) {
		this.queDate = queDate;
	}
	public int getAdmin_id() {
		return adminId;
	}
	public void setAdmin_id(int adminId) {
		this.adminId = adminId;
	}
	public int getStudent_id() {
		return studentId;
	}
	public void setStudent_id(int studentId) {
		this.studentId = studentId;
	}
	public int getIs_finish() {
		return isFinish;
	}
	public void setIs_finish(int isFinish) {
		this.isFinish = isFinish;
	}
	
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	@Override
	public String toString() {
		return "Problem [id=" + id + ", name=" + name + ", content=" + content + ", answer=" + answer + ", que_date="
				+ queDate + ", admin_id=" + adminId + ", student_id=" + studentId + ", is_finish=" + isFinish
				+ ", studentName=" + studentName + ", adminName=" + adminName + "]";
	}
	
}
