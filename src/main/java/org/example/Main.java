package org.example;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.example.services.DatabaseQueryService;

@Slf4j
public class Main {

    @SneakyThrows
    public static void main(String[] args) {
        //Class.forName("org.h2.Driver");
        log.info(new DatabaseQueryService().findLongestProject().toString());
        log.info(new DatabaseQueryService().findMaxProjectsCountClient().toString());
        log.info(new DatabaseQueryService().findMaxSalary().toString());
        log.info(new DatabaseQueryService().findProjectPrices().toString());
        log.info(new DatabaseQueryService().findYoungestEldestWorkers().toString());
    }

}