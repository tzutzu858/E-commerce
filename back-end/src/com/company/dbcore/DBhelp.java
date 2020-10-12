package com.company.dbcore;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 載入driver and 建立connection實例
 */
public class DBhelp {

    static Properties info = new Properties();

    static {
        //獲得屬性文件輸入流
        InputStream in = DBhelp.class.getClassLoader().getResourceAsStream("config.properties");

        try {
            //從文件讀取到變數 info
            info.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


//   private static String url = "jdbc:mysql://localhost:3306/mydb?verifyServerCertificate=false&useSSL=false";
//   private static String user = "root";
//   private static String password = "root123";

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName(info.getProperty("driver"));
        Connection connection = DriverManager.getConnection(info.getProperty("url"), info);
        return connection;
    }
}
