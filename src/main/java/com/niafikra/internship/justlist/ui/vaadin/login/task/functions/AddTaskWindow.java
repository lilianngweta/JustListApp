package com.niafikra.internship.justlist.ui.vaadin.login.task.functions;


import com.niafikra.internship.justlist.data.Project;
import com.niafikra.internship.justlist.service.TasksService;
import com.niafikra.internship.justlist.ui.vaadin.login.project.functions.ProjectsDisplay;
import com.vaadin.ui.*;

/**
 * Created by lilianngweta on 7/20/16.
 */
public class AddTaskWindow extends Window implements Button.ClickListener {


    private TextField textField;
    private Button saveTaskButton;
    private TasksService tasksService;
    private TasksDisplay tasksDisplay;
    private Project currentProject;
    private ProjectsDisplay projectsDisplay;

    public AddTaskWindow(TasksDisplay tasksDisplay){

        setTasksDisplay(tasksDisplay);

        textField = new TextField();
        saveTaskButton = new Button("Save");
        tasksService = TasksService.get();
        projectsDisplay = tasksDisplay.getTasksView().getTasksContent().getProjectsView().getProjectsDisplay();

        build();

    }

    private void build() {

        setCaption("Add Task");
        setWidth("500px");
        setHeight("200px");
        VerticalLayout content = new VerticalLayout();
        content.setWidth("500px");
        content.setSpacing(true);

        content.addComponent(textField);
        textField.setWidth("300px");
        content.setComponentAlignment(textField, Alignment.MIDDLE_CENTER);


        saveTaskButton.addClickListener(this);
        content.addComponent(saveTaskButton);
        content.setComponentAlignment(saveTaskButton, Alignment.MIDDLE_CENTER);

        setContent(content);
        center();

        UI.getCurrent().addWindow(this);

    }



    @Override
    public void buttonClick(Button.ClickEvent event) {

        boolean result = tasksService.save(textField.getValue(), projectsDisplay.getCurrentSelectedProject());

        if (result) {

            tasksDisplay.fetchTasks();
            close();
            //Notification.show("Successfully saved!!");

        }
    }

    public void setTasksDisplay(TasksDisplay tasksDisplay) {
        this.tasksDisplay = tasksDisplay;
    }


}
