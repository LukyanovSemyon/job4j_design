package ru.job4j.jdbc;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionDemo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Properties prs = new Properties();
        File file = new File("app.properties");
        try (FileInputStream io = new FileInputStream(file)) {
            prs.load(io);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Class.forName("org.postgresql.Driver");
        String url = prs.getProperty("url");
        String login = prs.getProperty("login");
        String password = prs.getProperty("password");
        try (Connection connection = DriverManager.getConnection(url, login, password)) {
            DatabaseMetaData metaData = connection.getMetaData();
            System.out.println(metaData.getUserName());
            System.out.println(metaData.getURL());
        }
    }
}
