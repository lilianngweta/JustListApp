package com.niafikra.internship.justlist.ui.vaadin.login.task.functions;

import com.niafikra.internship.justlist.data.Project;
import com.niafikra.internship.justlist.data.Task;
import com.niafikra.internship.justlist.service.TasksService;
import com.niafikra.internship.justlist.ui.vaadin.login.TasksView;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;

/**
 * Created by lilianngweta on 7/13/16.
 */
public class TasksHeader extends HorizontalLayout{

    private TasksService tasksService;
    private Project currentProject;
    private TasksView tasksView;
    private TasksDisplay tasksDisplay;
    private AddTaskWindow addTaskWindow;
    private Task task;


    public TasksHeader( TasksView tasksView){

        this.tasksView = tasksView;
        tasksDisplay = tasksView.getTasksDisplay();

        tasksService = TasksService.get();
        createTasksActions();

    }


    private void createTasksActions() {

        setSizeFull();
        //setSpacing(false);
        HorizontalLayout taskActions = new HorizontalLayout();
        addComponent(taskActions);
        //taskActions.setSizeFull();
        //taskActions.setSpacing(false);
        setComponentAlignment(taskActions,Alignment.TOP_LEFT);

        Button deleteButton = new Button("Delete");
        deleteButton.addClickListener(event -> {
            for (Object selectedTaskID : tasksDisplay.getGrid().getSelectedRows()){
                tasksService.delete((Task) selectedTaskID);
                tasksDisplay.getGrid().deselect(selectedTaskID);

            }


            tasksDisplay.fetchTasks();
        });

        taskActions.addComponent(deleteButton);
        //setComponentAlignment(taskActions,Alignment.BOTTOM_LEFT);

        Button completeButton = new Button("Complete");
        completeButton.addClickListener(event -> {

            for (Object selectedTaskID : tasksDisplay.getGrid().getSelectedRows()) {
//                task = (Task) selectedTaskID;
//               if (task.isCompleted()) {
                   tasksService.complete((Task) selectedTaskID);
                   tasksDisplay.getGrid().deselect(selectedTaskID);
//               }
//                else if(!task.isCompleted()) {
//                   tasksService.notCompleted((Task) selectedTaskID);
//                   tasksDisplay.getGrid().deselect(selectedTaskID);
//               }
            }
            tasksDisplay.fetchTasks();
        });
        taskActions.addComponent(completeButton);
        //setComponentAlignment(completeButton, Alignment.BOTTOM_LEFT);

        Button addTaskButton = new Button("Add Task");
        addTaskButton.setWidth("100px");
        addTaskButton.addClickListener(e ->{

            addTaskWindow = new AddTaskWindow(tasksView.getTasksDisplay());

        });

        taskActions.addComponent(addTaskButton);
        //setComponentAlignment(addTaskButton,Alignment.BOTTOM_LEFT);


    }


}
