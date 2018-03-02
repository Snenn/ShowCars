package com.showCars.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String URL_DB =
            "mysql://b0d44ae03093be:a254d195@us-cdbr-iron-east-05.cleardb.net/heroku_cfe833d95e08d49?reconnect=true";
    private static final String USER_DB = "b0d44ae03093be";
    private static final String PASSWORD_DB = "a254d195";


    //==============================================================================
    //регистрация драйвера
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //==============================================================================
    //аналог синглтона на случай множественного обращения
    private static volatile Connection connection = null;

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            synchronized (URL_DB) {
                if (connection == null || connection.isClosed())
                {

                    connection = DriverManager.getConnection(URL_DB, USER_DB, PASSWORD_DB);}
            }
        }
        return connection;
    }


}
