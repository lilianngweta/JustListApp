package com.niafikra.internship.justlist.ui.vaadin.login.task.functions;

import com.niafikra.internship.justlist.service.TasksService;
import com.vaadin.ui.*;

/**
 * Created by lilianngweta on 7/13/16.
 */
public class TasksHeader extends HorizontalLayout{

    private TextField textField;
    private Button addTask;
    private TasksService tasksService;
    private TasksDisplay tasksDisplay;

    public TasksHeader( TasksDisplay tasksDisplay){

        setTasksDisplay(tasksDisplay);

        tasksService = new TasksService();
        build();

    }

    private void build() {

        setSizeFull();
        textField = new TextField();
        textField.setWidth("100%");
        addComponent(textField);
        setComponentAlignment(textField, Alignment.TOP_CENTER);
        addTask = new Button("Add Task");
        addTask.setWidth("100px");
        setExpandRatio(textField,1);

        //addComponent(userService);
        addTask.addClickListener(e ->{

            tasksService.saveTask(textField.getValue());
            //removeAllComponents();
            tasksDisplay.fetchTasks();

        });
        addComponent(addTask);
        setComponentAlignment(addTask, Alignment.TOP_CENTER);

    }

    public void setTasksDisplay(TasksDisplay tasksDisplay) {
        this.tasksDisplay = tasksDisplay;
    }

    public TextField getTextField() {
        return textField;
    }

    public Button getAddTask() {
        return addTask;
    }
}
