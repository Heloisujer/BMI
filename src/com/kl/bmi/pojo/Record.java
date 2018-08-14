package com.kl.bmi.pojo;

import java.io.Serializable;

/**
 * 记录实体类
 * @author 胡家兴
 *
 */

public class Record implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String id;
	
	private String time;
	
	private double height;
	
	private double weight;
	
	private String sex;
	
	private double bmi;
	
	private double dream_value;
	
	public Record() {
		super();
	}

	public Record(String id, String time, double height, double weight, String sex, double bmi, double dream_value) {
		super();
		this.id = id;
		this.time = time;
		this.height = height;
		this.weight = weight;
		this.sex = sex;
		this.bmi = bmi;
		this.dream_value = dream_value;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public double getBmi() {
		return bmi;
	}

	public void setBmi(double bmi) {
		this.bmi = bmi;
	}

	public double getDream_value() {
		return dream_value;
	}

	public void setDream_value(double dream_value) {
		this.dream_value = dream_value;
	}

	@Override
	public String toString() {
		return "Record [id=" + id + ", time=" + time + ", height=" + height + ", weight=" + weight + ", sex=" + sex
				+ ", bmi=" + bmi + ", dream_value=" + dream_value + "]";
	}


}
