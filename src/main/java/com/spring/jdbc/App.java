package com.spring.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.jdbc.entity.Student;
import com.spring.jdbc.repository.StudentDAOImpl;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
//        System.out.println( "Hello World!" );
//        
//        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("config.xml");
//        
//        JdbcTemplate jdbcTemplate = applicationContext.getBean("jdbcTemplate",JdbcTemplate.class);
//        
//        //Insert Query
//        String query="insert into student_springjdbc values(?,?,?,?)";
//        
//        //Fire query
//        int update = jdbcTemplate.update(query,102,"John","Sydney",7632);
//        System.out.println("Number of rows updated - "+update);
    	
    	//Using .xml configurations
    	
    	ApplicationContext applicationContext=new ClassPathXmlApplicationContext("config.xml");
    	
    	
    	//Insert
//    	StudentDAOImpl daoImpl = (StudentDAOImpl) applicationContext.getBean("studentDao");
//    	Student student=new Student(103,"Kumar","Trivandrum",3214L);
//		daoImpl.addStudent(student);
//    	daoImpl.getStudents().forEach(System.out::println);
    	
    	//Update
    	//System.out.println(daoImpl.updateStudent(102));
    	
    	//Read
//    	Student searchStudent = daoImpl.searchStudent("Akash");
//    	System.out.println("Searched for ->"+searchStudent);
    	
    	
    	
    	
    	//Using Annotations
    	ApplicationContext context=new AnnotationConfigApplicationContext(JdbcConfig.class);
    	StudentDAOImpl daoImpl=context.getBean("studentDAOImpl",StudentDAOImpl.class);
    	
    	daoImpl.getStudents().forEach((student)->System.out.println(student));
    }
}
