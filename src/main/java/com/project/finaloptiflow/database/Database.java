package com.project.finaloptiflow.database;

import com.project.finaloptiflow.FactoryMethod.Person;
import com.project.finaloptiflow.FactoryMethod.User;
import com.project.finaloptiflow.FactoryMethod.UserSkillsFactory;
import com.project.finaloptiflow.FactoryMethod.Vacancy;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Database {
    Connection connection = DataBaseConnection.getInstance().getConnection();

    static String currentEmail;
    public static List<String> stringToList(String skills) {
        String[] skillsArray = skills.split(", ");
        return Arrays.asList(skillsArray);
    }

    public ResultSet checkUser(String login, String password) {
        ResultSet resultSet = null;
        String select = "SELECT * FROM users WHERE login = ? AND password = ?";
        try {
            PreparedStatement prSt = connection.prepareStatement(select);
            prSt.setString(1, login);
            prSt.setString(2, password);
            resultSet = prSt.executeQuery();

            Statement st = connection.createStatement();

            ResultSet rs = st.executeQuery("SELECT email FROM users WHERE login = '" + login + "';");
            while (rs.next()) {
                currentEmail = rs.getString(1);
            }
            System.out.println(currentEmail);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resultSet;
    }

    public ResultSet check(String login){
        PreparedStatement prSt = null;
        ResultSet resultSet = null;
        String select = "SELECT login FROM users WHERE login = '" + login + "';";

        try {
            prSt = connection.prepareStatement(select);
            resultSet = prSt.executeQuery();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resultSet;
    }

    public void signUpUser(String login, String firstName, String lastname, String email, String password) {
        PreparedStatement prSt = null;
        String insert = "INSERT INTO users VALUES(?, ?, ?, ?, ?);";
        try {
            prSt = connection.prepareStatement(insert);
            prSt.setString(1, login);
            prSt.setString(2, firstName);
            prSt.setString(3, lastname);
            prSt.setString(4, email);
            prSt.setString(5, password);

            currentEmail = email;

            prSt.executeUpdate();
        } catch (SQLException e) {
            System.out.println();
        }
    }

    public void update(String usernameLike, String newPassword){
        String update = "UPDATE users SET password = ? WHERE login = " + "'" +usernameLike + "';";
        PreparedStatement prepStatement = null;
        try {
            prepStatement = connection.prepareStatement(update);
            prepStatement.setString(1, newPassword);
            prepStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void request(String company_name, String contact_name, String email, String phone, String company_description){
        String insert = "INSERT INTO company_requests VALUES(?, ?, ?, ?, ?);";
        try {
            PreparedStatement prSt = connection.prepareStatement(insert);
            prSt.setString(1, company_name);
            prSt.setString(2, contact_name);
            prSt.setString(3, email);
            prSt.setString(4, phone);
            prSt.setString(5, company_description);
            prSt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void workExperience(String position, String skills, String work_period, String email){
        String insert = "INSERT INTO work_experience VALUES(?, ?, ?, ?);";
        try {
            PreparedStatement prSt = connection.prepareStatement(insert);
            prSt.setString(1, position);
            prSt.setString(2, skills);
            prSt.setString(3, work_period);
            prSt.setString(4, email);

            prSt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Person getSkills() {
        List<String> stringList = new ArrayList<>();
        ResultSet resSet = null;
        Person person;
        String select = "SELECT skills FROM work_experience WHERE email = ?;";
        PreparedStatement prSt = null;
        try {
            prSt = connection.prepareStatement(select);
            prSt.setString(1, currentEmail);
            resSet = prSt.executeQuery();
            while (resSet.next()) {
                String value = resSet.getString("skills");
                stringList = stringToList(value);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        person = new UserSkillsFactory().create(stringList);
        return person;
    }
    public Vacancy getVacancy(String vacancy_name) {
        Vacancy vacancy = new Vacancy();
        ResultSet resultSet = null;
        String select = "SELECT * FROM vacancy WHERE vacancy_name = ?;";
        PreparedStatement prSt = null;
        try {
            prSt = connection.prepareStatement(select);
            prSt.setString(1, vacancy_name);
            resultSet = prSt.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("vacancy_name");
                String description = resultSet.getString("vacancy_description");
                String period = resultSet.getString("work_period");
                String skills = resultSet.getString("skills");
                String salary = resultSet.getString("salary");
                vacancy = new Vacancy(name, description, period, stringToList(skills), salary);

            }
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return vacancy;
    }

    public String getFirstName(){
        String firstname = null;
        String lastname = null;
        String select = "SELECT firstname, lastname FROM users WHERE email = " + "'" + currentEmail + "';";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(select);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                firstname = resultSet.getString("firstname");
                lastname = resultSet.getString("lastname");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return firstname + " " + lastname;

    }

    protected List<User> getUser() {
        return null;
    }
}
