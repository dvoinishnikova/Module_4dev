package org.example.services;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.example.Database;
import org.example.util.QueryUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

@Slf4j
public class DatabaseInitService {

    @SneakyThrows
    public static void main(String[] args) {
        try (Connection connection = Database.getInstance().getConnection()) {
            Statement statement = connection.createStatement();
            String executeQuery = QueryUtils.getSQLQueryFromFile("sql/init_db.sql");
            try {
                statement.execute(executeQuery);
                log.info("Initialization successful");
            } catch (SQLException e) {
                e.printStackTrace();
                log.error("Wrong query - [{}], please review the statement", executeQuery, e);
            }
        }
    }

}