package com.niafikra.internship.justlist.ui.vaadin.login.task.functions;

import com.niafikra.internship.justlist.data.Project;
import com.niafikra.internship.justlist.data.Task;
import com.niafikra.internship.justlist.service.TasksService;
import com.niafikra.internship.justlist.ui.vaadin.login.TasksView;
import com.niafikra.internship.justlist.ui.vaadin.login.project.functions.ProjectsDisplay;
import com.vaadin.data.Item;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.data.util.GeneratedPropertyContainer;
import com.vaadin.data.util.PropertyValueGenerator;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.renderers.ButtonRenderer;

/**
 * Created by lilianngweta on 7/14/16.
 */
public class TasksDisplay extends HorizontalLayout {

    private TasksService tasksService;
    private BeanItemContainer<Task> container;
    private Project currentProject;
    private TasksView tasksView;
    private Grid grid;

    public TasksDisplay(TasksView tasksView){

        setSizeFull();

        this.tasksView = tasksView;

        tasksService = TasksService.get();
        container = new BeanItemContainer<Task>(Task.class);

        /**
         * Generate button caption column
         */
        GeneratedPropertyContainer gpc = new GeneratedPropertyContainer(container);
        gpc.addGeneratedProperty("delete",
                new PropertyValueGenerator<String>() {

                    @Override
                    public String getValue(Item item, Object itemId,
                                           Object propertyId) {
                        return "Delete"; // The caption
                    }

                    @Override
                    public Class<String> getType() {
                        return String.class;
                    }
                });

        /**
         * Create a grid
         */
        grid = new Grid(gpc);

        /**
         * Render a button that deletes the data row (item)
         */
        grid.getColumn("delete").setRenderer(new ButtonRenderer(e -> {
            Task task = (Task) e.getItemId();
            grid.getContainerDataSource().removeItem(e.getItemId());
            tasksService.delete(task);
        }));

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

    public BeanItemContainer<Task> getContainer() {
        return container;
    }

    public Grid getGrid() {
        return grid;
    }
}
