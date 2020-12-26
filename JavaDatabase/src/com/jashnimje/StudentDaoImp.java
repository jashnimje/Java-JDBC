package com.jashnimje;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class StudentDaoImp implements StudentDao {
	
	private Student getStudentFromResultSet(ResultSet rs) throws SQLException
	{
		Student s = new Student();
		s.setRollno(rs.getInt("rollno"));
		s.setSname(rs.getString("sname"));
		s.setScore(rs.getDouble("score"));
		return s;
	}

	@Override
	public Student getStudent(Integer rollno) {
		Connection conn = null;
		try {
			conn = ConnectionFactory.getConnection();
			PreparedStatement st = conn.prepareStatement("select * from student where rollno = ?");
			st.setInt(1, rollno);
			ResultSet rs = st.executeQuery();
			if (rs.next()) 
			{
				return getStudentFromResultSet(rs);
			}
			
		} 
		catch(SQLException ex) 
		{
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean insertStudent(Student s) {
		Connection conn = null;
		try {
			conn = ConnectionFactory.getConnection();
			PreparedStatement st = conn.prepareStatement("insert into student values(?,?,?)");
			st.setInt(1, s.getRollno());
			st.setString(2, s.getSname());
			st.setDouble(3, s.getScore());
			int i = st.executeUpdate();
			if (i == 1) 
			{
				return true;
			}
			
		} 
		catch(SQLException ex) 
		{
			ex.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteStudent(Integer rollno) {
		Connection conn = null;
		try {
			conn = ConnectionFactory.getConnection();
			PreparedStatement st=conn.prepareStatement("delete from student where rollno = ?");
			st.setInt(1, rollno);
			int i = st.executeUpdate();
			if(i==1)
			{
				System.out.println("Delete successful.");
				return true;
			}
		}
		catch(SQLException ex) 
		{
			ex.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateStudent(Student s) {
		Connection conn = null;
		try {
			conn = ConnectionFactory.getConnection();
			PreparedStatement st = conn.prepareStatement("update student set sname = ?, score = ? where rollno = ?");
			st.setString(1, s.getSname());
			st.setDouble(2, s.getScore());
			st.setInt(3, s.getRollno());
			int i = st.executeUpdate();
			if (i == 1) 
			{
				System.out.println("Update Successful");
				return true;
			}
			
		} 
		catch(SQLException ex) 
		{
			ex.printStackTrace();
		}
		return false;
	}

	@Override
	public Set<Student> getAllStudents() {
		Connection conn = null;
		try {
			conn = ConnectionFactory.getConnection();
			PreparedStatement st = conn.prepareStatement("select * from student");
			ResultSet rs = st.executeQuery();
			Set<Student> students = new HashSet<Student>();
			while(rs.next())
			{
				Student s = getStudentFromResultSet(rs);
				students.add(s);
			}
			return students;
		} 
		catch(SQLException ex) 
		{
			ex.printStackTrace();
		}
		return null;
	}

}
