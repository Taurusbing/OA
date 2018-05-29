package com.hpeu.oa.entity;

import java.sql.Timestamp;

public class Problem {
	private int id;
	private String name;
	private String content;
	private String answer;
	private Timestamp que_date;
	private int admin_id;
	private int student_id;
	private int is_finish;
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
		return que_date.toString();
	}
	public void setQue_date(Timestamp que_date) {
		this.que_date = que_date;
	}
	public int getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(int admin_id) {
		this.admin_id = admin_id;
	}
	public int getStudent_id() {
		return student_id;
	}
	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}
	public int getIs_finish() {
		return is_finish;
	}
	public void setIs_finish(int is_finish) {
		this.is_finish = is_finish;
	}
	@Override
	public String toString() {
		return "Problem [id=" + id + ", name=" + name + ", content=" + content + ", answer=" + answer + ", que_date="
				+ que_date + ", admin_id=" + admin_id + ", student_id=" + student_id + ", is_finish=" + is_finish + "]";
	}
	
}
