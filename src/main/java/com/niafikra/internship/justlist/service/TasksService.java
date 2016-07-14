package com.niafikra.internship.justlist.service;

import com.niafikra.internship.justlist.data.Task;
import com.niafikra.internship.justlist.mysql.MySqlConnector;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lilianngweta on 7/13/16.
 */
public class TasksService {

    private Task task;

    Connection connection = MySqlConnector.getConnection();

    public TasksService() {

        // saveTask();

      //  showTask();
    }


    public void saveTask(String task) {

        try {
            Statement statement = connection.createStatement();

            String query = "INSERT INTO Task (TaskName) " + "VALUES ('" + task + "')";

            statement.executeUpdate(query);


        } catch (SQLException e) {
            e.printStackTrace();
        }


    }


    public List<Task> addTasks() {

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
            e.printStackTrace();
        }

        return taskList;
    }




}




