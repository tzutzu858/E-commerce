package com.company.dbcore;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBHelp {

    static Properties info = new Properties();

    static {
        // 獲得屬性文件輸入流
        InputStream in = DBHelp.class.getClassLoader().getResourceAsStream("config.properties");

        try {
            // 從屬性文件讀取到變量info
            info.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException, ClassNotFoundException {

        Class.forName(info.getProperty("driver"));

        Connection connection = DriverManager.getConnection(info.getProperty("url"), info);
        return connection;
    }
}
