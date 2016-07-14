package com.niafikra.internship.justlist.service;

import com.niafikra.internship.justlist.mysql.MySqlConnector;

import java.sql.*;

/**
 * Created by lilianngweta on 7/12/16.
 */
public class ProjectService {

    Connection connection = MySqlConnector.getConnection();

    private static ProjectService projectService;

   // private Project project;

    public static ProjectService get() {

        if (projectService == null)
            projectService = new ProjectService();

        return projectService;
    }


    public boolean save(String name){

        Statement statement = null;

        try {
            statement = connection.createStatement();

            String query = "INSERT INTO Project (Name)" + "VALUES ('" + name + "')";

            statement.executeUpdate(query);



            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }


    }


}





