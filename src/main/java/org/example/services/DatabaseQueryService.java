package org.example.services;

import lombok.extern.slf4j.Slf4j;
import org.example.Database;
import org.example.dto.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.*;

import static org.example.util.QueryUtils.getSQLQueryFromFile;

@Slf4j
public class DatabaseQueryService {

    private static final String FILE_FOLDER = "sql/";
    Statement statement;

    public DatabaseQueryService() throws SQLException {
        statement = Database.getInstance()
                .getConnection()
                .createStatement();
    }

    public List<LongestProject> findLongestProject() throws SQLException {
        List<LongestProject> longestProjects = new ArrayList<>();
        ResultSet resultSet = statement
                .executeQuery(getSQLQueryFromFile(FILE_FOLDER + "find_longest_project.sql"));
        while (resultSet.next()) {
            String name = resultSet.getString("name");
            int monthCount = resultSet.getInt("month_count");
            longestProjects.add(new LongestProject(name, monthCount));
        }
        return longestProjects;
    }

    public List<MaxProjectCountClient> findMaxProjectsCountClient() throws SQLException {
        List<MaxProjectCountClient> maxProjectCountClients = new ArrayList<>();
        ResultSet resultSet = statement
                .executeQuery(getSQLQueryFromFile(FILE_FOLDER + "find_max_projects_client.sql"));
        while (resultSet.next()) {
            String name = resultSet.getString("name");
            int projectCount = resultSet.getInt("project_count");
            maxProjectCountClients.add(new MaxProjectCountClient(name, projectCount));
        }
        return maxProjectCountClients;
    }

    public List<MaxSalaryWorker> findMaxSalary() throws SQLException {
        List<MaxSalaryWorker> maxSalary = new ArrayList<>();
        ResultSet resultSet = statement
                .executeQuery(getSQLQueryFromFile(FILE_FOLDER + "find_max_salary_worker.sql"));
        while (resultSet.next()) {
            String name = resultSet.getString("name");
            int salary = resultSet.getInt("salary");
            maxSalary.add(new MaxSalaryWorker(name, salary));
        }
        return maxSalary;
    }

    public List<ProjectPrices> findProjectPrices() throws SQLException {
        List<ProjectPrices> projectPrices = new ArrayList<>();
        ResultSet resultSet = statement
                .executeQuery(getSQLQueryFromFile(FILE_FOLDER + "print_project_prices.sql"));
        while (resultSet.next()) {
            String name = resultSet.getString("name");
            int price = resultSet.getInt("price");
            projectPrices.add(new ProjectPrices(name, price));
        }
        return projectPrices;
    }

    public List<YoungestEldestWorkers> findYoungestEldestWorkers() throws SQLException {
        List<YoungestEldestWorkers> youngestOldestsWorkersList = new ArrayList<>();
        ResultSet resultSet = statement
                .executeQuery(getSQLQueryFromFile(FILE_FOLDER + "find_youngest_eldest_workers.sql"));
        while (resultSet.next()) {
            String type = resultSet.getString("type");
            String name = resultSet.getString("name");
            LocalDate date = LocalDate.parse(resultSet.getString("birthday"));
            youngestOldestsWorkersList.add(new YoungestEldestWorkers(type, name, date));
        }
        return youngestOldestsWorkersList;
    }

}