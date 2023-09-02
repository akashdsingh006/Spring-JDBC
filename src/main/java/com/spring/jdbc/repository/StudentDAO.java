package com.spring.jdbc.repository;

import java.util.List;

import com.spring.jdbc.entity.Student;

public interface StudentDAO {
	public boolean addStudent(Student student);
	public List<Student> getStudents();
	public boolean updateStudent(int id);
	public Student searchStudent(String name);
}
