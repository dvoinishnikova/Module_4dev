package org.example.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

public class QueryUtils {
    public static String getSQLQueryFromFile(String fileName) {
        StringBuilder builder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(
                new FileReader(getFilePath(fileName)))) {
            String line;
            while ((line = reader.readLine()) != null) {
                builder.append(line.trim()).append(" ");
            }
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
        return builder.toString();
    }

    public static String getFilePath(String file) throws URISyntaxException {
        ClassLoader classLoader = QueryUtils.class.getClassLoader();
        URL resource = classLoader.getResource(file);
        Path path = Paths.get(Objects.requireNonNull(resource).toURI());
        return path.toString();
    }


}
