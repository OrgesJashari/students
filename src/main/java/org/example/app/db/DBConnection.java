package org.example.app.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private Connection connection;

    public DBConnection() {
        this.connection = connection;
    }

    public Connection connect() {

        try {
            String dbUrl = "jdbc:postgres://localhost:5432/shkolla";
            String user = "postgres";
            String password = "123456";
            this.connection = DriverManager.getConnection(dbUrl, user, password);
            System.out.println("Connected to postgres database sucessfully");
        } catch (SQLException e) {
            System.out.println("We coudnt connect to database.");
            e.printStackTrace();
        }
        return connection;
    }

    public Connection getConnection() {
        return this.connection;
    }
}



