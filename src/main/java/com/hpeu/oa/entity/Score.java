package com.hpeu.oa.entity;
/**
 * 学生成绩实体
 * Score <br>
 * 创建人: Taurus <br>
 */
public class Score {
	private int id;
	private String userName;
	private float one;
	private float two;
	private float three;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public float getOne() {
		return one;
	}
	public void setOne(float one) {
		this.one = one;
	}
	public float getTwo() {
		return two;
	}
	public void setTwo(float two) {
		this.two = two;
	}
	public float getThree() {
		return three;
	}
	public void setThree(float three) {
		this.three = three;
	}
	@Override
	public String toString() {
		return "Score [id=" + id + ", userName=" + userName + ", one=" + one + ", two=" + two + ", three=" + three
				+ "]";
	}
	
}
