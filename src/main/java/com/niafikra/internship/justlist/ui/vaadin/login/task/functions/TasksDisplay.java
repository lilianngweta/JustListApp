package com.niafikra.internship.justlist.ui.vaadin.login.task.functions;

import com.niafikra.internship.justlist.data.Project;
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

    private Project currentProject;

    public TasksDisplay(){

        tasksService = TasksService.get();
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
        container.addAll(tasksService.getTasks(currentProject));
    }

    public void setCurrentProject(Project currentProject) {
        this.currentProject = currentProject;

        fetchTasks();
    }
}
