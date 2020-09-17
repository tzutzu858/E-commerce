package WebStore.dbcore;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcTemplate {

    public void query(PreparedStatementCreator pscreator,
                      RowCallbackHandler callbackHandler) throws DataAccessException {
        /**
         *執行查詢動作
         * @param pscreator 建立語句物件
         * @param callbackHandler resultSet處理物件
         * @throws DataAccessException
         */
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DBhelp.getConnection();
            preparedStatement = pscreator.createPreparedStatement(connection);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                callbackHandler.processRow(resultSet);
            }
        } catch (SQLException e) {
            throw new DataAccessException("SQLException of JdbcTemplate", e);
        } catch (ClassNotFoundException e) {
            throw new DataAccessException("ClassNotFoundException of JdbcTemplate", e);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new DataAccessException("JdbcTemplate 不能關閉資料庫連結", e);
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    throw new DataAccessException("JdbcTemplate 不能放指令物件", e);
                }
            }
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    throw new DataAccessException("JdbcTemplate 無法關閉resultSet物件", e);
                }
            }
        }
    }
    /**
     * 資料修改操作
     *
     * @param pscreator 建立語句物件
     * @throws DataAccessException
     */

    public void update(PreparedStatementCreator pscreator)
            throws DataAccessException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = DBhelp.getConnection();
            preparedStatement = pscreator.createPreparedStatement(connection);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DataAccessException("SQLException of JdbcTemplate", e);
        } catch (ClassNotFoundException e) {
            throw new DataAccessException("ClassNotFoundException of JdbcTemplate", e);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new DataAccessException("JdbcTemplate 不能關閉資料庫連結", e);
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    throw new DataAccessException("JdbcTemplate 不能放指令物件", e);
                }
            }
        }
    }
}
