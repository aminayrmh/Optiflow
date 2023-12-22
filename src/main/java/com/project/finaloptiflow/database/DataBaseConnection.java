package com.project.finaloptiflow.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

    public class DataBaseConnection extends Configs {
        private String URL = "jdbc:postgresql://" + dbHost + ":" + dbPort + "/" + dbName;

        private static DataBaseConnection instance;
        private final Connection connection;

        private DataBaseConnection(){
            try {
                Class.forName("org.postgresql.Driver");
                this.connection = DriverManager.getConnection(URL, dbUser, dbPassword);
            } catch (SQLException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

        public static synchronized DataBaseConnection getInstance(){
            if(instance == null) instance = new DataBaseConnection();
            return instance;
        }

        public Connection getConnection(){
            return connection;
        }
    }

