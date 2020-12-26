package com.jashnimje;

import java.util.Iterator;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		StudentDao studentIntf = new StudentDaoImp();
		/*
		studentIntf.insertStudent(new Student(36, "Jash", 90.25));
		studentIntf.insertStudent(new Student(46, "Vineet", 74.25));
		*/
		Set<Student> studs = studentIntf.getAllStudents();
		Iterator<Student> it = studs.iterator();
		while (it.hasNext()) 
		{
			Student s = it.next();
			System.out.println(s.getRollno() + " , " + s.getSname() + " , " + s.getScore());
			
		}
		Student s1 = studentIntf.getStudent(36);
		s1.setScore(72.5);
		studentIntf.updateStudent(s1);
		System.out.println("After Update");
		studs = studentIntf.getAllStudents();
		it = studs.iterator();
		while (it.hasNext()) 
		{
			Student s = it.next();
			System.out.println(s.getRollno() + " , " + s.getSname() + " , " + s.getScore());
			
		}
		studentIntf.deleteStudent(46);
		System.out.println("After Delete");
		studs = studentIntf.getAllStudents();
		it = studs.iterator();
		while (it.hasNext()) 
		{
			Student s = it.next();
			System.out.println(s.getRollno() + " , " + s.getSname() + " , " + s.getScore());
			
		}
	}
}
