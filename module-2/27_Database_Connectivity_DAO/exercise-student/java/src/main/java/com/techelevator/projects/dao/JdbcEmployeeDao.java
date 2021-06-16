package com.techelevator.projects.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.techelevator.projects.model.Department;
import org.springframework.jdbc.core.JdbcTemplate;

import com.techelevator.projects.model.Employee;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JdbcEmployeeDao implements EmployeeDao {

	private final JdbcTemplate jdbcTemplate;

	public JdbcEmployeeDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> employees = new ArrayList<>();
		SqlRowSet results = jdbcTemplate.queryForRowSet("SELECT employee_id, department_id, first_name, last_name, birth_date, hire_date FROM employee;");
		while (results.next()) {
			employees.add(mapRowToEmployee(results));
		}

		return employees;

	}

	@Override
	public List<Employee> searchEmployeesByName(String firstNameSearch, String lastNameSearch) {
		List<Employee> employees = new ArrayList<>();
		String sql = "SELECT employee_id, department_id, first_name, last_name, birth_date, hire_date " +
					 "FROM employee " +
					 "WHERE first_name ILIKE ? AND last_name ILIKE ?;";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, "%" + firstNameSearch + "%","%" + lastNameSearch + "%");
		while (results.next()) {
			employees.add(mapRowToEmployee(results));
		}

		return employees;
	}

	@Override
	public List<Employee> getEmployeesByProjectId(Long projectId) {
		return new ArrayList<>();
	}

	@Override
	public void addEmployeeToProject(Long projectId, Long employeeId) {
	}

	@Override
	public void removeEmployeeFromProject(Long projectId, Long employeeId) {
	}

	@Override
	public List<Employee> getEmployeesWithoutProjects() {
		return new ArrayList<>();
	}


	private Employee mapRowToEmployee(SqlRowSet rowSet) {
		Employee employee = new Employee();
		employee.setId(rowSet.getLong("employee_id"));
		employee.setDepartmentId(rowSet.getLong("department_id"));
		employee.setFirstName(rowSet.getString("first_name"));
		employee.setLastName(rowSet.getString("last_name"));
		employee.setBirthDate(rowSet.getDate("birth_date").toLocalDate());
		employee.setHireDate(rowSet.getDate("hire_date").toLocalDate());

		return employee;

	}

}
