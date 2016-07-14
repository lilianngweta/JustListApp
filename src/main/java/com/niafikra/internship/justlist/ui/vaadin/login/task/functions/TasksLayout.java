package com.niafikra.internship.justlist.ui.vaadin.login.task.functions;

import com.niafikra.internship.justlist.service.TasksService;
import com.niafikra.internship.justlist.ui.vaadin.login.project.functions.TasksDisplay;
import com.vaadin.ui.*;

/**
 * Created by lilianngweta on 7/13/16.
 */
public class TasksLayout extends HorizontalLayout{

    private TextField textField;
    private Button addTask;
    private TasksService tasksService;
    private TasksDisplay tasksDisplay;

    public TasksLayout(){

        tasksService = new TasksService();

        tasksDisplay = new TasksDisplay();


        build();

    }

    private void build() {

        setSizeFull();
        textField = new TextField();
        textField.setWidth("700px");
        addComponent(textField);
        setComponentAlignment(textField, Alignment.TOP_CENTER);
        addTask = new Button("Add Task");
        addTask.setWidth("100px");

        //addComponent(userService);
        addTask.addClickListener(e ->{

            tasksService.saveTask(textField.getValue());
            tasksDisplay.showTasks();

        });
        addComponent(addTask);
        setComponentAlignment(addTask, Alignment.TOP_CENTER);

    }


    public TextField getTextField() {
        return textField;
    }

    public Button getAddTask() {
        return addTask;
    }
}
