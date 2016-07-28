package com.niafikra.internship.justlist.ui.vaadin.login.task.functions;

import com.niafikra.internship.justlist.data.Project;
import com.niafikra.internship.justlist.data.Task;
import com.niafikra.internship.justlist.service.TasksService;
import com.niafikra.internship.justlist.ui.vaadin.login.TasksView;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.ui.Button;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.VerticalLayout;

/**
 * Created by lilianngweta on 7/14/16.
 */
public class TasksDisplay extends VerticalLayout {

    private TasksService tasksService;
    private BeanItemContainer<Task> container;
    private Project currentProject;
    private TasksView tasksView;
    private Grid grid;

    public TasksDisplay(TasksView tasksView) {

        tasksService = TasksService.get();
        this.tasksView = tasksView;


        setSizeFull();
        createTasksActions();
        createTasksGrid();
    }

    private void createTasksActions() {
        HorizontalLayout actions = new HorizontalLayout();
        addComponent(actions);
        Button deleteButton = new Button("Delete");
        deleteButton.addClickListener(event -> {
            for (Object selectedTaskID : grid.getSelectedRows())
                tasksService.delete((Task) selectedTaskID);

            fetchTasks();
        });
        actions.addComponent(deleteButton);

        Button completeButton = new Button("Complete");
        completeButton.addClickListener(event -> {
            for (Object selectedTaskID : grid.getSelectedRows())
                tasksService.complete((Task) selectedTaskID);

            fetchTasks();
        });
        actions.addComponent(completeButton);
    }

    private void createTasksGrid() {
        container = new BeanItemContainer<Task>(Task.class);

        /**
         * Create a grid
         */
        grid = new Grid(container);
        grid.setSelectionMode(Grid.SelectionMode.MULTI);

        //Grid.MultiSelectionModel selection = (Grid.MultiSelectionModel) grid.getSelectionModel();

        //selection.setSelected(grid.getContainerDataSource().);

        grid.getColumn("name").setExpandRatio(1);
        grid.getColumn("delete").setWidth(100);
        grid.removeColumn("id");
        grid.removeColumn("user");
        grid.removeColumn("project");
        addComponent(grid);
        setExpandRatio(grid, 1);
        grid.setWidth("100%");
        grid.setSizeFull();

    }

    public void fetchTasks() {
        container.removeAllItems();

        if (currentProject != null)
            container.addAll(tasksService.getTasks(currentProject));
    }

    public TasksView getTasksView() {
        return tasksView;
    }


    public void setCurrentProject(Project currentProject) {
        this.currentProject = currentProject;

        fetchTasks();
    }

    public BeanItemContainer<Task> getContainer() {
        return container;
    }

    public Grid getGrid() {
        return grid;
    }
}
