package com.techelevator.projects.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.techelevator.projects.model.Department;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.projects.model.Project;

public class JdbcProjectDao implements ProjectDao {

	private final JdbcTemplate jdbcTemplate;

	public JdbcProjectDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public Project getProject(Long projectId) {
		Project project = null;
		String sql = "SELECT project_id, name, from_date, to_date " +
				     "FROM project " +
				     "WHERE project_id = ?;";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, projectId);
		if (results.next()) {
			project = mapRowToProject(results);
		}
		return project;
	}

	@Override
	public List<Project> getAllProjects() {
		List<Project> projects = new ArrayList<>();
		SqlRowSet results = jdbcTemplate.queryForRowSet("SELECT project_id, name, from_date, to_date FROM project;");
		while (results.next()) {
			projects.add(mapRowToProject(results));
		}

		return projects;
	}

	@Override
	public Project createProject(Project newProject) {
		String sql = "INSERT INTO project (name, from_date, to_date) " +
					 "VALUES (?, ?, ?) RETURNING project_id;";

		Long newId = jdbcTemplate.queryForObject(sql, Long.class,
				newProject.getName(), newProject.getFromDate(), newProject.getToDate());

		return getProject(newId);
	}

	@Override
	public void deleteProject(Long projectId) {
		String sql = "DELETE FROM project_employee WHERE project_id = ?; " +
				     "DELETE FROM project WHERE project_id = ?";
		jdbcTemplate.update(sql, projectId, projectId);

	}

	private Project mapRowToProject(SqlRowSet rowSet) {
		Project project = new Project();
		if(rowSet.getDate("from_date") != null){
			project.setFromDate(rowSet.getDate("from_date").toLocalDate());
		}
		if(rowSet.getDate("to_date") != null){
			project.setToDate(rowSet.getDate("to_date").toLocalDate());
		}


		project.setName(rowSet.getString("name"));
		project.setId(rowSet.getLong("project_id"));


		return project;


	}
}
