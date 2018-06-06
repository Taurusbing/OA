package com.hpeu.oa.entity;

public class ResourceVO {
	private int id;
	private String filename;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	@Override
	public String toString() {
		return "ResourceVO [id=" + id + ", filename=" + filename + "]";
	}
}
