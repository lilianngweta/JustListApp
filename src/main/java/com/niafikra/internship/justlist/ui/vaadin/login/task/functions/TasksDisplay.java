package com.niafikra.internship.justlist.ui.vaadin.login.task.functions;

import com.niafikra.internship.justlist.data.Project;
import com.niafikra.internship.justlist.data.Task;
import com.niafikra.internship.justlist.service.TasksService;
import com.niafikra.internship.justlist.ui.vaadin.login.TasksView;
import com.niafikra.internship.justlist.ui.vaadin.login.project.functions.ProjectsDisplay;
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
    private TasksView tasksView;
   // private ProjectsDisplay projectsDisplay;

    public TasksDisplay(TasksView tasksView){

        this.tasksView = tasksView;

        //projectsDisplay = new ProjectsDisplay(tasksView.getTasksContent().getProjectsView());

        tasksService = TasksService.get();
        container =
                new BeanItemContainer<Task>(Task.class);
        setSizeFull();

        Grid grid = new Grid(container);

        grid.removeColumn("id");
        grid.removeColumn("user");
        grid.removeColumn("project");
        addComponent(grid);
        grid.setWidth("100%");
        grid.setSizeFull();


    }

    public void fetchTasks(){
        container.removeAllItems();
        container.addAll(tasksService.getTasks(currentProject));
    }

    public TasksView getTasksView() {
        return tasksView;
    }


    public void setCurrentProject(Project currentProject) {
        this.currentProject = currentProject;

        fetchTasks();
    }
}
