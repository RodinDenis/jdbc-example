package com.github.rodindenis.jdbcexample;

import com.github.rodindenis.ExampleJDBC;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExampleJDBCIT {

    private ExampleJDBC exampleJDBC = new ExampleJDBC("jdbc:h2:target/example");

    @BeforeAll
    static  void setUp() throws ClassNotFoundException {
        Class.forName("org.h2.Driver");
    }

    @Test
    void selectExample() throws SQLException {

        assertEquals(Optional.of("VW"),exampleJDBC.selectColumn());
    }

    @Test
    void selectTwoColomns() throws SQLException {
        assertEquals(Optional.of("Name: JACK, age: 5"), exampleJDBC.selectTwoColumns());
    }
}
