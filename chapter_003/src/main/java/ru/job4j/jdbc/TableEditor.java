package ru.job4j.jdbc;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class TableEditor implements AutoCloseable {

    private Connection connection;

    private final Properties properties;

    public TableEditor(Properties properties) throws SQLException {
        this.properties = properties;
        initConnection();
    }

    private void initConnection() throws SQLException {
        String url = properties.getProperty("url");
        String login = properties.getProperty("login");
        String password = properties.getProperty("password");
        connection = DriverManager.getConnection(url, login, password);
    }

    public void createTable(String tableName) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            String sql = String.format(
                    "create table if not exists %s(id serial primary key, name varchar(255));",
                    tableName
            );
            statement.execute(sql);
        }
    }

    public void dropTable(String tableName) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            String sql = String.format(
                    "drop table if exists %s;", tableName
            );
            statement.execute(sql);
        }
    }

    public void addColumn(String tableName, String columnName, String type) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            String sql = String.format(
                    "alter table %s add column if not exists %s %s;",
                    tableName, columnName, type
            );
            statement.execute(sql);
        }
    }

    public void dropColumn(String tableName, String columnName) throws SQLException {
            try (Statement statement = connection.createStatement()) {
                String sql = String.format(
                        "alter table %s drop column if exists %s;",
                        tableName, columnName
                );
                statement.execute(sql);
        }
    }

    public void renameColumn(String tableName, String columnName, String newColumnName) throws SQLException {
            try (Statement statement = connection.createStatement()) {
                String sql = String.format(
                        "alter table %s rename column %s to %s;",
                        tableName, columnName, newColumnName
                );
                statement.execute(sql);
        }
    }

    public String getScheme(String tableName) throws SQLException {
        StringBuilder scheme = new StringBuilder();
        DatabaseMetaData metaData = connection.getMetaData();
        try (ResultSet columns = metaData.getColumns(null, null, tableName, null)) {
            scheme.append(String.format("%-15s %-15s%n", "column", "type"));
            while (columns.next()) {
                scheme.append(String.format("%-15s %-15s%n",
                        columns.getString("COLUMN_NAME"),
                        columns.getString("TYPE_NAME")));
            }
        }
        return scheme.toString();
    }

    @Override
    public void close() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }

    private static Properties getProperties() {
        Properties prs = new Properties();
        File file = new File("app.properties");
        try (FileInputStream io = new FileInputStream(file)) {
            prs.load(io);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prs;
    }

    public static void main(String[] args) throws Exception {
        TableEditor te = new TableEditor(getProperties());
        String tableName = "new_table";
        String columnName = "new_column";
        String type = "varchar(255)";
        String newColumnName = "new2_column";
        te.createTable(tableName);
        System.out.println(te.getScheme(tableName));
        te.dropTable(tableName);
        System.out.println(te.getScheme(tableName));
        te.createTable(tableName);
        System.out.println(te.getScheme(tableName));
        te.addColumn(tableName, columnName, type);
        System.out.println(te.getScheme(tableName));
        te.dropColumn(tableName, columnName);
        System.out.println(te.getScheme(tableName));
        te.addColumn(tableName, columnName, type);
        System.out.println(te.getScheme(tableName));
        te.renameColumn(tableName, columnName, newColumnName);
        System.out.println(te.getScheme(tableName));
        te.close();
    }
}
