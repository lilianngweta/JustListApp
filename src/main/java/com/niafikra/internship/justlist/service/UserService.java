package com.niafikra.internship.justlist.service;

import com.niafikra.internship.justlist.data.User;
import com.niafikra.internship.justlist.mysql.MySqlConnector;

import java.sql.*;

/**
 * Created by lilianngweta on 6/27/16.
 */
public class UserService {

    private Connection connection = MySqlConnector.getConnection();
    private User currentSessionUser;

    private static UserService userService;

    public static UserService get() {
        if (userService == null)
            userService = new UserService();

        return userService;
    }


    public User getUser(Long userID) {

        try {
            PreparedStatement userStatement = connection.prepareStatement("SELECT * FROM User WHERE id='" + userID + "'");

            ResultSet result = userStatement.executeQuery();
            if (result.next()) {
                User user = new User();
                user.setId(result.getLong("id"));
                user.setFullName(result.getString("fullName"));
                user.setEmail(result.getString("email"));
                user.setPassword(result.getString("password"));
                return user;
            } else return null;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }


    }

    public boolean register(User user) {

        Statement statement = null;
        try {
            statement = connection.createStatement();
            String query = "INSERT INTO User (fullName, email, password)" + "VALUES ('" + user.getFullName() + "','" + user.getEmail() + "','" + user.getPassword() + "')";

            statement.executeUpdate(query);
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;

        }

    }


    public User authenticate(String email, String password) {

        String query1 = "SELECT*FROM User WHERE Email = '" + email + "' AND Password = '" + password + "'";

        PreparedStatement userStatement = null;
        try {

            userStatement = connection.prepareStatement(query1);

            ResultSet result = userStatement.executeQuery();

            if (!result.next()) return null;
            else {
                User user = new User();

                user.setId(result.getLong("id"));
                user.setFullName(result.getString("fullName"));
                user.setEmail(result.getString("email"));
                user.setPassword(result.getString("password"));

                currentSessionUser = user;

                return user;

            }


        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    public User getCurrentSessionUser() {
        return currentSessionUser;
    }
}

