package com.spring.jdbc;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

//import com.spring.jdbc.repository.StudentDAOImpl;

@Configuration
@ComponentScan(basePackages = {"com.spring.jdbc"})
public class JdbcConfig {

	@Bean(name = "{dataSource}")
	public DataSource getDataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("org.postgresql.Driver");
		ds.setUrl("jdbc:postgresql://localhost:5432/postgres");
		ds.setUsername("postgres");
		ds.setPassword("akash");

		return ds;
	}

	@Bean(name = { "jdbcTemplate" })
	public JdbcTemplate getJdbcTemplate() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
		// jdbcTemplate.set

		return jdbcTemplate;
	}

//	@Bean(name = { "studentDao" })
//	public StudentDAOImpl getStudent() {
//		StudentDAOImpl daoImpl = new StudentDAOImpl();
//		daoImpl.setJdbcTemplate(getJdbcTemplate());
//		return daoImpl;
//	}
}
