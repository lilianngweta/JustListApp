package com.niafikra.internship.justlist.ui.vaadin.login.task.functions;

import com.niafikra.internship.justlist.data.Project;
import com.niafikra.internship.justlist.data.Task;
import com.niafikra.internship.justlist.service.TasksService;
import com.niafikra.internship.justlist.ui.vaadin.login.TasksView;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.data.util.filter.SimpleStringFilter;
import com.vaadin.event.FieldEvents;
import com.vaadin.ui.*;

/**
 * Created by lilianngweta on 7/14/16.
 */
public class TasksDisplay extends VerticalLayout {

    private TextField searchTaskBar;
    private TasksService tasksService;
    private BeanItemContainer<Task> container;
    private Project currentProject;
    private TasksView tasksView;
    private Grid grid;
    //private Button addTaskButton;

    public TasksDisplay(TasksView tasksView) {

        tasksService = TasksService.get();
        this.tasksView = tasksView;


        setSizeFull();
        setSpacing(false);
        build();
        createTasksGrid();
    }


    private void createTasksGrid() {
        container = new BeanItemContainer<Task>(Task.class);

        /**
         * Create a grid
         */
        grid = new Grid(container);
        grid.setSelectionMode(Grid.SelectionMode.MULTI);
        grid.setRowStyleGenerator(new Grid.RowStyleGenerator() {
            @Override
            public String getStyle(Grid.RowReference row) {
                Task task = (Task) row.getItemId();
                return task.isCompleted() ? "task-completed" : "task-not-completed";
            }
        });

        //Grid.MultiSelectionModel selection = (Grid.MultiSelectionModel) grid.getSelectionModel();

        //selection.setSelected(grid.getContainerDataSource().);

//        grid.getColumn("name").setExpandRatio(1);
//        grid.getColumn("delete").setWidth(100);
        grid.removeColumn("id");
        grid.removeColumn("user");
        grid.removeColumn("project");
        addComponent(grid);
        setExpandRatio(grid, 1);
        grid.setWidth("100%");
        grid.setSizeFull();

    }


    private void build() {

        setSizeFull();
        HorizontalLayout searchTask = new HorizontalLayout();
        addComponent(searchTask);
        searchTask.setWidth("100%");

        /**
         *  An input field to use for filter
         */
        searchTaskBar = new TextField();

        searchTaskBar.setInputPrompt("Search task by name...");

        /**
         * On Change of text, filter the data of the grid
         */
        searchTaskBar.addTextChangeListener(getTasksListener());
        searchTaskBar.setImmediate(true);

        searchTaskBar.setWidth("100%");
        addComponent(searchTaskBar);
        setComponentAlignment(searchTaskBar, Alignment.TOP_CENTER);
        //setExpandRatio(searchTaskBar,1);

        searchTask.addComponent(searchTaskBar);

        //addComponent(userService);

//        addComponent(addTaskButton);
//        setComponentAlignment(addTaskButton, Alignment.TOP_CENTER);

    }

    /**
     * Returns the TextChangeListener that gets triggered
     *
     * @return
     */

    private FieldEvents.TextChangeListener getTasksListener() {
        return new FieldEvents.TextChangeListener() {

            @Override
            public void textChange(FieldEvents.TextChangeEvent event) {
                String newValue = (String) event.getText();

                /**
                 * This removes the previous filter that was used to filter the container
                 */
                container.removeContainerFilters("name");

                if (null != newValue && !newValue.isEmpty()) {
                    //Set new filter for the "name" column
                    container.addContainerFilter(new SimpleStringFilter(
                            "name", newValue, true, false));
                }
                grid.recalculateColumnWidths();
            }
        };

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
