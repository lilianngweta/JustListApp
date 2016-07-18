package com.niafikra.internship.justlist.service;

import com.niafikra.internship.justlist.data.Project;
import com.niafikra.internship.justlist.data.Task;
import com.niafikra.internship.justlist.mysql.MySqlConnector;
import com.vaadin.ui.Notification;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
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


    public void save(String task, Project currentProject) {

        try {
            Statement statement = connection.createStatement();

            String query = "INSERT INTO Task (name) " + "VALUES ('" + task + "')";

            statement.executeUpdate(query);


        } catch (SQLException e) {
            e.printStackTrace();
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


    public Collection<Task> getTasks(Project project) {
        return null;
    }
}




