package WebStore.dbcore;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 建立預編譯的指令實例
 */

public interface PreparedStatementCreator {

    PreparedStatement createPreparedStatement(Connection conn)throws SQLException;
}
