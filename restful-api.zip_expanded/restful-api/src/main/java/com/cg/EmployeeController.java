package com.cg;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class EmployeeController { 

	@Autowired
	JdbcTemplate jt;
	
	//getting all employees
	@RequestMapping(value = "/employee", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Employee> getEmployees() {

		List<Employee> list = jt.query("select id, name from employee", new RowMapper<Employee>(){

			@Override
			public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new Employee(rs.getInt(1), rs.getString(2));
			}

		});
		return list;		
	}

	//get employees by id
	@RequestMapping(value = "/employee/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Employee getEmployeeById(@PathVariable("id") int id) {

		Employee emp = this.jt.queryForObject("select id, name from employee where id = ?", new Object[] {id},
				new RowMapper<Employee>() {
			@Override
			public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new Employee(rs.getInt(1), rs.getString(2));
			}
		});
		return emp;
	}

	//insert employee
	@RequestMapping(value = "/employee", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String insertEmployee(@RequestBody Employee emp) {
		int status = this.jt.update("insert into employee values(?, ?)", emp.getId(), emp.getName());
		if(status > 0)
			return "Employee added successfully"+emp.getId();
		else {
			return "Employee could not be added";
		}
	}

	//delete employee
	@RequestMapping(value = "/employee/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public String deleteEmployee(@PathVariable("id") int id) {
		this.jt.update("delete from employee where id = ?", new Object[] {id});
		return "employee deleted";
	}

	
	@RequestMapping(value = "/employee", method = RequestMethod.PUT)
	public String updateEmployee(@RequestBody Employee emp) {
		int status = this.jt.update("update  employee set id = ?, name=? where id = ?", emp.getId(), emp.getName(), emp.getId());
		if(status >0)
			return "Employee Updated successfully"+emp.getId();
		else {
			return "Employee could not be updated";
		}
	}
}
