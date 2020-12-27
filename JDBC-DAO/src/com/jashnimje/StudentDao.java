package com.jashnimje;
import java.util.Set;

public interface StudentDao {

	Student getStudent(Integer rollno);
	boolean insertStudent(Student s);
	boolean deleteStudent(Integer rollno);
	boolean updateStudent(Student s);
	Set<Student> getAllStudents();
}
