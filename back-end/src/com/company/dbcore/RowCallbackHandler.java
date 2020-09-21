package com.company.dbcore;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 處理resultSet
 */

public interface RowCallbackHandler {
    void processRow(ResultSet rs)throws SQLException;
}
