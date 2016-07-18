package com.niafikra.internship.justlist.service;

import com.niafikra.internship.justlist.data.Project;
import com.niafikra.internship.justlist.mysql.MySqlConnector;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lilianngweta on 7/12/16.
 */
public class ProjectService {

    Connection connection = MySqlConnector.getConnection();

    private static ProjectService projectService;

   private Project project;

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

    public Project getProject(Long  projectID){
        return null;
    }

    public List<Project> getProjects(){

        List<Project> projectList = new ArrayList<Project>();

        try {
            PreparedStatement projectItem = connection.prepareStatement("SELECT *FROM Project");

            ResultSet resultSet = projectItem.executeQuery();

            while(resultSet.next()){

                project = new Project();
                project.setId(resultSet.getLong("id"));
                project.setName(resultSet.getString("Name"));

                projectList.add(project);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return projectList;
    }


}





