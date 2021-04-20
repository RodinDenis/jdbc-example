package com.github.rodindenis;

import java.sql.*;
import java.util.Optional;

public class ExampleJDBC {
    private String url;

    public ExampleJDBC(String url) {
        this.url = url;
    }

    public Optional<String> selectColumn() throws SQLException {
        try(Connection connection = getConnection1().orElseThrow(JDBCConnectionException::new)) {
            try(Statement statement = connection.createStatement()) {
                try(ResultSet resultSet = statement.executeQuery("select name from machine")) {
                    if (resultSet.next()) {
                        return Optional.of(resultSet.getString("NAME"));
                    } else {
                        return Optional.empty();
                    }
                }
            }
        }
    }

    public Optional<String> selectTwoColumns() throws SQLException {
        try(Connection connection = getConnection1().orElseThrow(JDBCConnectionException::new)) {
            try(Statement statement = connection.createStatement()) {
                try(ResultSet resultSet = statement.executeQuery("select name, age from animal")) {
                    if (resultSet.next()) {
                        return Optional.of(String.format("Name: %s, age: %d", resultSet.getString("NAME"), resultSet.getInt("age")));
                    } else {
                        return Optional.empty();
                    }
                }
            }
        }
    }

    private Optional<Connection> getConnection1() throws SQLException {
        return Optional.ofNullable(DriverManager.getConnection(url));
    }

}
