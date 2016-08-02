package com.niafikra.internship.justlist.ui.vaadin.login.task.functions;

import com.niafikra.internship.justlist.data.Project;
import com.niafikra.internship.justlist.data.Task;
import com.niafikra.internship.justlist.service.TasksService;
import com.niafikra.internship.justlist.ui.vaadin.login.TasksView;
import com.vaadin.data.util.filter.SimpleStringFilter;
import com.vaadin.event.FieldEvents;
import com.vaadin.ui.*;

/**
 * Created by lilianngweta on 7/13/16.
 */
public class TasksHeader extends HorizontalLayout{

    private TasksService tasksService;
    private Project currentProject;
    private TasksView tasksView;
    private TasksDisplay tasksDisplay;
    private AddTaskWindow addTaskWindow;


    public TasksHeader( TasksView tasksView){

        this.tasksView = tasksView;
        tasksDisplay = tasksView.getTasksDisplay();

        //build();
        //setMargin(true);
        createTasksActions();

    }


    private void createTasksActions() {

        setSizeFull();
        //setSpacing(false);
        HorizontalLayout actions = new HorizontalLayout();
        addComponent(actions);
        setComponentAlignment(actions,Alignment.BOTTOM_LEFT);

        Button deleteButton = new Button("Delete");
        deleteButton.addClickListener(event -> {
            for (Object selectedTaskID : tasksDisplay.getGrid().getSelectedRows()){
                tasksService.delete((Task) selectedTaskID);
                tasksDisplay.getGrid().deselect(selectedTaskID);

            }


            tasksDisplay.fetchTasks();
        });

        actions.addComponent(deleteButton);
        //setComponentAlignment(actions,Alignment.BOTTOM_LEFT);

        Button completeButton = new Button("Complete");
        completeButton.addClickListener(event -> {
            for (Object selectedTaskID : tasksDisplay.getGrid().getSelectedRows()) {
                tasksService.complete((Task) selectedTaskID);
                tasksDisplay.getGrid().deselect(selectedTaskID);
            }
            tasksDisplay.fetchTasks();
        });
        actions.addComponent(completeButton);
        //setComponentAlignment(completeButton, Alignment.BOTTOM_LEFT);

        Button addTaskButton = new Button("Add Task");
        addTaskButton.setWidth("100px");
        addTaskButton.addClickListener(e ->{

            addTaskWindow = new AddTaskWindow(tasksView.getTasksDisplay());

        });

        actions.addComponent(addTaskButton);
        //setComponentAlignment(addTaskButton,Alignment.BOTTOM_LEFT);


    }


}
