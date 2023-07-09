package org.example;

import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Slf4j
public class Database {
    private static final String URL = "jdbc:h2:mem:mydatabase";
    private static final String USERNAME = "myuser";
    private static final String PASSWORD = "mypassword";

    private static Database instance;
    private Connection connection;

    private Database() {

    }

    public Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                log.info("Database connected!");
            } catch (SQLException e) {
                throw new IllegalStateException("Cannot connect the database!", e);
            }
        }
        return connection;
    }


    public static synchronized Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }


}