package com.niafikra.internship.justlist.ui.vaadin.login.task.functions;

import com.niafikra.internship.justlist.data.Project;
import com.niafikra.internship.justlist.service.TasksService;
import com.niafikra.internship.justlist.ui.vaadin.login.TasksView;
import com.niafikra.internship.justlist.ui.vaadin.login.project.functions.AddProjectWindow;
import com.vaadin.ui.*;

/**
 * Created by lilianngweta on 7/13/16.
 */
public class TasksHeader extends HorizontalLayout{

    private TextField searchTaskBar;
    private Button addTaskButton;
    private TasksService tasksService;
    private TasksDisplay tasksDisplay;
    private Project currentProject;
    private TasksView tasksView;
    private AddTaskWindow addTaskWindow;


    public TasksHeader( TasksView tasksView){

        this.tasksView = tasksView;

        //setTasksDisplay(tasksDisplay);

       // tasksService = TasksService.get();
        build();

    }

    private void build() {

        setSizeFull();
        searchTaskBar = new TextField();
        searchTaskBar.setWidth("100%");
        addComponent(searchTaskBar);
        setComponentAlignment(searchTaskBar, Alignment.TOP_CENTER);
        addTaskButton = new Button("Add Task");
        addTaskButton.setWidth("100px");
        setExpandRatio(searchTaskBar,1);

        //addComponent(userService);
        addTaskButton.addClickListener(e ->{

            addTaskWindow = new AddTaskWindow(tasksView.getTasksDisplay());

//
//            String taskName= searchTaskBar.getValue();

//            tasksService.save(taskName, currentProject);
//            //removeAllComponents();
//            tasksDisplay.fetchTasks();

        });
        addComponent(addTaskButton);
        setComponentAlignment(addTaskButton, Alignment.TOP_CENTER);

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
