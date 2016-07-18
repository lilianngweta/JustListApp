package com.niafikra.internship.justlist.service;

import com.niafikra.internship.justlist.data.Project;
import com.niafikra.internship.justlist.data.User;
import com.niafikra.internship.justlist.mysql.MySqlConnector;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by lilianngweta on 7/12/16.
 */
public class ProjectService {

    private Connection connection = MySqlConnector.getConnection();

    private static ProjectService projectService;

    public static ProjectService get() {

        if (projectService == null)
            projectService = new ProjectService();

        return projectService;
    }


    public boolean save(String projectName, User user) {

        PreparedStatement statement = null;

        try {
            String query = "INSERT INTO Project (name,user_id) VALUES (?,?)";
            statement = connection.prepareStatement(query);
            statement.setString(1, projectName);
            statement.setLong(2, user.getId());
            statement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Project getProject(Long projectID) {
        PreparedStatement projectStatement;
        try {
            projectStatement = connection.prepareStatement("SELECT * FROM Project WHERE id = ?");
            projectStatement.setLong(1, projectID);
            ResultSet result = projectStatement.executeQuery();

            if (result.next()) {
                Project project = new Project();
                project.setId(result.getLong("id"));
                project.setName(result.getString("name"));

                return project;
            } else return null;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    public List<Project> getProjects(User user) {
        String query = "SELECT * FROM Project WHERE user_id= ?";

        PreparedStatement statement;

        List<Project> projects = new LinkedList<>();
        try {
            statement = connection.prepareStatement(query);
            statement.setLong(1,user.getId());

            ResultSet resultSet= statement.executeQuery();

            while (resultSet.next()){
                projects.add(
                        new Project(
                                resultSet.getLong("id"),
                                resultSet.getString("name"),
                                UserService.get().getUser(resultSet.getLong("user_id"))
                        )
                );
            }

            return projects;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Project> getProjects() {

        List<Project> projectList = new ArrayList<Project>();

        try {
            PreparedStatement projectItem = connection.prepareStatement("SELECT *FROM Project");

            ResultSet resultSet = projectItem.executeQuery();

            while (resultSet.next()) {

                Project project = new Project();
                project.setId(resultSet.getLong("id"));
                project.setName(resultSet.getString("name"));

                projectList.add(project);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return projectList;
    }


}





