package com.jashnimje;

public class Student {
	private Integer rollno;
	private String sname;
	private Double score;
	public Student() {
		
	}
	public Student(Integer rollno, String sname, Double score) {
		super();
		this.rollno = rollno;
		this.sname = sname;
		this.score = score;
	}
	public Integer getRollno() {
		return rollno;
	}
	public void setRollno(Integer rollno) {
		this.rollno = rollno;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public Double getScore() {
		return score;
	}
	public void setScore(Double score) {
		this.score = score;
	}
	
}
