package com.github.rodindenis;

import java.sql.*;
import java.util.Optional;

public class ExampleJDBC {
    private String url;

    public ExampleJDBC(String url) {
        this.url = url;
    }

    public Optional<String> selectColumn() throws SQLException {
        Connection connection = DriverManager.getConnection(url);
        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("select name from machine");

        if (resultSet.next()) {
            return Optional.of(resultSet.getString("NAME"));
        } else {
            return Optional.empty();
        }
    }
}
