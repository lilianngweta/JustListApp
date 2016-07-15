package com.niafikra.internship.justlist.ui.vaadin.login.task.functions;

import com.niafikra.internship.justlist.data.Task;
import com.niafikra.internship.justlist.service.TasksService;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;

/**
 * Created by lilianngweta on 7/14/16.
 */
public class TasksDisplay extends HorizontalLayout {

    private TasksService tasksService;
    private BeanItemContainer<Task> container;
    //private Task task;

    public TasksDisplay(){

        tasksService = new TasksService();
        container =
                new BeanItemContainer<Task>(Task.class);
        setSizeFull();

        Grid grid = new Grid(container);

        addComponent(grid);
        grid.setWidth("100%");
        grid.setSizeFull();


        fetchTasks();

    }

    public void fetchTasks(){
        container.removeAllItems();
        container.addAll(tasksService.getTasks());
    }


}