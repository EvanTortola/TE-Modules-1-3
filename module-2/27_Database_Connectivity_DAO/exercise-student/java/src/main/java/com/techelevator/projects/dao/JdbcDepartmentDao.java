package com.techelevator.projects.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;
import javax.sql.RowSet;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.projects.model.Department;

public class JdbcDepartmentDao implements DepartmentDao {

	private final JdbcTemplate jdbcTemplate;

	public JdbcDepartmentDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public Department getDepartment(Long id) {
		Department dept = null;

		String deptSql = "SELECT department_id, name " +
				"FROM department " +
				"WHERE department_id = ?;";

		SqlRowSet results = jdbcTemplate.queryForRowSet(deptSql, id);
		if (results.next()) {
			dept = new Department();
			dept.setName(results.getString("name"));
			dept.setId(results.getLong("department_id"));
		}
		return dept;
	}

	@Override
	public List<Department> getAllDepartments() {
		List<Department> dept = new ArrayList<>();
		SqlRowSet results = jdbcTemplate.queryForRowSet("SELECT department_id, name FROM department;");
		while (results.next()) {
			dept.add(mapRowToDepartment(results));
		}

		return dept;
	}

	@Override
	public void updateDepartment(Department updatedDepartment) {
		String sql = "UPDATE department " +
					 "SET name = ? " +
				     "WHERE department_id = ?;";
		jdbcTemplate.update(sql, updatedDepartment.getName(), updatedDepartment.getId());

	}

	private Department mapRowToDepartment(SqlRowSet rowSet) {
		Department department = new Department();
		department.setName(rowSet.getString("name"));
		department.setId(rowSet.getLong("department_id"));
		return department;

	}

}