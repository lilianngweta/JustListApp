package com.niafikra.internship.justlist.ui.vaadin.login.project.functions;

import com.niafikra.internship.justlist.data.Task;
import com.niafikra.internship.justlist.service.TasksService;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.VerticalLayout;

/**
 * Created by lilianngweta on 7/14/16.
 */
public class TasksDisplay extends HorizontalLayout {

    private TasksService tasksService;

    public TasksDisplay(){

        tasksService = new TasksService();

        //showTasks();

    }

    public void showTasks (){


        BeanItemContainer<Task> container =
                new BeanItemContainer<Task>(Task.class, tasksService.addTasks());

        Grid grid = new Grid(container);
        //grid.setColumnOrder("Task");

        addComponent(grid);

    }


}
