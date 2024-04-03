package com.db;

import java.sql.*;

public class DbConnection {


    public static void main(String[] args) {
        String url = "jdbc:oracle:thin:scott/tiger@//host:1521/service";
        String userName = "";
        String password = "";
        String sql ="SELECT *FROM EMP";
        try (Connection connection = DriverManager.getConnection(url, userName, password)) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            resultSet.getString(1);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
