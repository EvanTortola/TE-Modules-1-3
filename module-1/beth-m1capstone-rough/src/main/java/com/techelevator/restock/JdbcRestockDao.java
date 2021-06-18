package com.techelevator.restock;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class JdbcRestockDao implements RestockDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcRestockDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<RestockProduct> getRestockList() {

        List<RestockProduct> restockProductList = new ArrayList<>();

        String sql = "SELECT slot_id, description, price, snack_type " +
                "FROM vm_item;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            restockProductList.add(mapRowToRestockProduct(results));
        }
        return restockProductList;

    }

    private RestockProduct mapRowToRestockProduct(SqlRowSet rowSet) {
        RestockProduct restockProduct = new RestockProduct();

        restockProduct.setProductClass(rowSet.getString("snack_type"));
        restockProduct.setProductName(rowSet.getString("description"));
        restockProduct.setSalePrice(rowSet.getBigDecimal("price"));
        restockProduct.setSlotName(rowSet.getString("slot_id"));

        return restockProduct;
    }


}
