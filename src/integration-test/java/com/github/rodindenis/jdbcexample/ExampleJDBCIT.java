package com.github.rodindenis.jdbcexample;

import com.github.rodindenis.ExampleJDBC;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExampleJDBCIT {

    @BeforeEach
    void setUp() throws ClassNotFoundException {
        Class.forName("org.h2.Driver");
    }

    @Test
    void example() throws SQLException {
        ExampleJDBC exampleJDBC = new ExampleJDBC("jdbc:h2:target/example");

        assertEquals(Optional.of("VW"),exampleJDBC.selectColumn());
    }
}
