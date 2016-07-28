package com.niafikra.internship.justlist.ui.vaadin.login.task.functions;

import com.niafikra.internship.justlist.data.Project;
import com.niafikra.internship.justlist.data.Task;
import com.niafikra.internship.justlist.service.TasksService;
import com.niafikra.internship.justlist.ui.vaadin.login.TasksView;
import com.vaadin.data.Item;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.data.util.GeneratedPropertyContainer;
import com.vaadin.data.util.PropertyValueGenerator;
import com.vaadin.shared.ui.checkbox.CheckBoxServerRpc;
import com.vaadin.ui.CheckBox;
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

    public TasksDisplay(TasksView tasksView) {

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


//        /* Generate checkbox caption column*/
//        GeneratedPropertyContainer gpc1 =
//                new GeneratedPropertyContainer(gpc);
//        gpc.addGeneratedProperty("checkbox",
//                new PropertyValueGenerator<String>() {
//
//                    @Override
//                    public String getValue(Item item, Object itemId,
//                                           Object propertyId) {
//                        return "CheckBox"; // The caption
//                    }
//
//                    @Override
//                    public Class<String> getType() {
//                        return String.class;
//                    }
//                });



        /**
         * Create a grid
         */
        grid = new Grid(gpc);

        /**
         * Render a button that deletes the data row (item)
         */
        grid.getColumn("delete").setRenderer(new ButtonRenderer(e -> {
            Task task = (Task) e.getItemId();
            if (tasksService.delete(task))
                grid.getContainerDataSource().removeItem(e.getItemId());
        }));

//        grid.getColumn("checkbox").setRenderer(new CheckboxRenderer(e -> {
//
//                grid.getContainerDataSource().s;
//        }));

        grid.setSelectionMode(Grid.SelectionMode.MULTI);

        //Grid.MultiSelectionModel selection = (Grid.MultiSelectionModel) grid.getSelectionModel();

        //selection.setSelected(grid.getContainerDataSource().);

        grid.getColumn("name").setExpandRatio(1);
        grid.getColumn("delete").setWidth(100);
        grid.removeColumn("id");
        grid.removeColumn("user");
        grid.removeColumn("project");
        addComponent(grid);
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
