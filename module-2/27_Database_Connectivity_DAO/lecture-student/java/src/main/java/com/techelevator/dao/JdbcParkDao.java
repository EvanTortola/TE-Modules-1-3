package com.techelevator.dao;

import com.techelevator.model.Park;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class JdbcParkDao implements ParkDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcParkDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Park getPark(long parkId) {
        Park myPark = new Park();

        String parkSql = "SELECT park_id, park_name, date_established, area, has_camping " +
                "FROM park " +
                "WHERE park_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(parkSql, parkId);
        if(results.next()) {
          myPark = mapRowToPark(results);
        }
        return  myPark;
    }

    @Override
    public List<Park> getParksByState(String stateAbbreviation) {
        return new ArrayList<Park>();
    }

    @Override
    public Park createPark(Park park) {
        return new Park();
    }

    @Override
    public void updatePark(Park park) {

    }

    @Override
    public void deletePark(long parkId) {

    }

    @Override
    public void addParkToState(long parkId, String stateAbbreviation) {
        String sql = "INSERT INTO park_state (park_id, state_abbreviaiton) " +
                "VALUES (?, ?);";
        jdbcTemplate.update(sql, parkId, stateAbbreviation);



    }

    @Override
    public void removeParkFromState(long parkId, String stateAbbreviation) {

    }

    private Park mapRowToPark(SqlRowSet results) {

        Park park = new Park();
        park.setParkId(results.getLong("park_id"));
        park.setParkName(results.getString("park_name"));
        park.setDateEstablished(results.getDate("date_established").toLocalDate());
        park.setArea(results.getDouble("area"));
        park.setHasCamping(results.getBoolean("has_camping"));
        return new Park();
    }
}
