package com.niafikra.internship.justlist.service;

import com.niafikra.internship.justlist.data.Project;
import com.niafikra.internship.justlist.data.Task;
import com.niafikra.internship.justlist.mysql.MySqlConnector;
import com.vaadin.ui.Notification;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by lilianngweta on 7/13/16.
 */
public class TasksService {

    private Task task;

    Connection connection = MySqlConnector.getConnection();

    private static TasksService tasksService;

    public TasksService() {

    }

    public static TasksService get(){

        if (tasksService == null)
            tasksService = new TasksService();

        return tasksService;
    }


    public boolean save(String task, Project currentProject) {

        PreparedStatement statement;

        try {

            String query = "INSERT INTO Task (name, project_id) " + "VALUES (?,?)";
            statement = connection.prepareStatement(query);
            statement.setString(1,task);
            statement.setLong(2,currentProject.getId());
            statement.execute();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();

            return false;
        }


    }

    public Task getTask(Long taskID){

        try {
            PreparedStatement taskStatement = connection.prepareStatement("SELECT * FROM Task WHERE id ='"+taskID+"'");

            ResultSet result = taskStatement.executeQuery();

            while (result.next()){
                task = new Task();
                task.setName(result.getString("name"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return task;
    }

    public List<Task> getTasks(Project project) {

        List<Task> tasks = new LinkedList<Task>();

        PreparedStatement statement;

        String query = "SELECT * FROM Task WHERE project_id= ?";

        try {
            statement = connection.prepareStatement(query);
            statement.setLong(1, project.getId());

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){

                tasks.add(new Task(
                        resultSet.getLong("id"),
                        resultSet.getString("name"),
                        ProjectService.get().getProject(resultSet.getLong("project_id")))
                );

            }

            return tasks;


        } catch (SQLException e) {
            e.printStackTrace();

            return null;
        }


    }

    public List<Task> getTasks() {

        List<Task> taskList = new ArrayList<Task>();


        PreparedStatement taskItem = null;
        try {

            taskItem = connection.prepareStatement("SELECT *FROM Task");
            ResultSet result = taskItem.executeQuery();


            while (result.next()) {

                task = new Task();
                task.setName(result.getString("name"));

                taskList.add(task);

            }



        } catch (SQLException e) {
            Notification.show(e.getMessage());
            e.printStackTrace();
        }
       // Notification.show(taskList.toString());
        return taskList;
    }


    public boolean delete(Task task){

        PreparedStatement preparedStmt = null;
        try {
            /**
             * create the mysql delete statement.
             */
            String query = "DELETE FROM Task where id = ?";
            preparedStmt = connection.prepareStatement(query);
            preparedStmt.setLong(1,task.getId());

            /**
             * execute the preparedstatement
             */
            return preparedStmt.execute();


        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }




}




