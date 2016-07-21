package com.niafikra.internship.justlist.ui.vaadin.login.task.functions;

import com.niafikra.internship.justlist.data.Project;
import com.niafikra.internship.justlist.service.TasksService;
import com.niafikra.internship.justlist.ui.vaadin.login.TasksView;
import com.vaadin.data.util.filter.SimpleStringFilter;
import com.vaadin.event.FieldEvents;
import com.vaadin.ui.*;

/**
 * Created by lilianngweta on 7/13/16.
 */
public class TasksHeader extends HorizontalLayout{

    private TextField searchTaskBar;
    private Button addTaskButton;
    private TasksService tasksService;
    private Project currentProject;
    private TasksView tasksView;
    private AddTaskWindow addTaskWindow;
    private TasksDisplay tasksDisplay;


    public TasksHeader( TasksView tasksView){

        this.tasksView = tasksView;
        tasksDisplay = tasksView.getTasksDisplay();

        //setTasksDisplay(tasksDisplay);

       // tasksService = TasksService.get();
        build();

    }

    private void build() {

        setSizeFull();

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
        addTaskButton = new Button("Add Task");
        addTaskButton.setWidth("100px");
        setExpandRatio(searchTaskBar,1);

        //addComponent(userService);
        addTaskButton.addClickListener(e ->{

            addTaskWindow = new AddTaskWindow(tasksView.getTasksDisplay());

        });
        addComponent(addTaskButton);
        setComponentAlignment(addTaskButton, Alignment.TOP_CENTER);

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
                tasksDisplay.getContainer().removeContainerFilters("name");

                if (null != newValue && !newValue.isEmpty()) {
                    //Set new filter for the "name" column
                    tasksDisplay.getContainer().addContainerFilter(new SimpleStringFilter(
                            "name", newValue, true, false));
                }
                tasksDisplay.getGrid().recalculateColumnWidths();
            }
        };

    }




//    public void setTasksDisplay(TasksDisplay tasksDisplay) {
//        this.tasksDisplay = tasksDisplay;
//    }
//
//    public TextField getSearchTaskBar() {
//        return searchTaskBar;
//    }
//
//    public Button getAddTaskButton() {
//        return addTaskButton;
//    }
//
//   public void setCurrentProject(Project currentProject) {
//       this.currentProject = currentProject;
    //}
}
