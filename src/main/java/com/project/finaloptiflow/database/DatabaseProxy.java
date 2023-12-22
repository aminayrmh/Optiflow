package com.project.finaloptiflow.database;

import com.project.finaloptiflow.FactoryMethod.Person;
import com.project.finaloptiflow.FactoryMethod.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class DatabaseProxy extends Database {
    private Database realDatabase;

    public DatabaseProxy() {
        this.realDatabase = new Database();
    }

    @Override
    public ResultSet checkUser(String login, String password) {
        System.out.println("Proxy: Checking user credentials for login: " + login);
        return realDatabase.checkUser(login, password);
    }

    @Override
    public ResultSet check(String login) {
        System.out.println("Proxy: Checking if login exists: " + login);
        return realDatabase.check(login);
    }

    @Override
    public List<User> getUser() {
        System.out.println("Proxy: Getting person data");
        return realDatabase.getUser();
    }

}
