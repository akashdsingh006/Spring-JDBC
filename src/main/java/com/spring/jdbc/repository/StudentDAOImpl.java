package com.spring.jdbc.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.spring.jdbc.entity.Student;

@Component
public class StudentDAOImpl implements StudentDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public boolean addStudent(Student student) {
		String query="INSERT INTO STUDENT_SPRINGJDBC VALUES(?,?,?,?)";
		
		int update = jdbcTemplate.update(query,student.getId(),student.getName(),student.getCity(),student.getPhone());
		
		return update==1?true:false;
	}

	public List<Student> getStudents() {
		
		String query="SELECT * FROM STUDENT_SPRINGJDBC ORDER BY id ASC ";
		
		RowMapper<Student> rowMapper= (rs,rowNum)->{
			Student student=new Student();
			student.setId(rs.getInt(1));
			student.setName(rs.getString(2));
			student.setCity(rs.getString(3));
			student.setPhone(rs.getLong(4));
			
			return student;
		};
		
		
		List<Student> result = this.jdbcTemplate.query(query, rowMapper);
		
		return result;
	}

	public boolean updateStudent(int id) {
		// TODO Auto-generated method stub
		
		String query="UPDATE STUDENT_SPRINGJDBC SET name=? where id=?";
		int update = this.jdbcTemplate.update(query, "Boban",id);
		
		if(update==1)
			return true;
		return false;
	}

	@Override
	public Student searchStudent(String name) {
		String query="select * from student_springjdbc where name=?";
		
		RowMapper<Student> rowMapper=(rs,rowNum)->{
			Student student=new Student();
			student.setId(rs.getInt(1));
			student.setName(rs.getString(2));
			student.setCity(rs.getString(3));
			student.setPhone(rs.getLong(4));
			
			return student;
		};
		
		Student student = this.jdbcTemplate.queryForObject(query, rowMapper, name);
		return student; 
	}

}
