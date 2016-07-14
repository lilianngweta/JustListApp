package com.niafikra.internship.justlist.ui.vaadin.login;
import com.niafikra.internship.justlist.ui.vaadin.login.project.functions.TasksDisplay;
import com.niafikra.internship.justlist.ui.vaadin.login.task.functions.TasksLayout;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.VerticalLayout;

/**
 * Created by lilianngweta on 7/11/16.
 */
public class TasksView extends VerticalLayout {

    private TasksLayout tasksLayout;
    //private TasksDisplay tasksDisplay;

    public TasksView(){

        tasksLayout = new TasksLayout();
       // tasksDisplay = new TasksDisplay();
        build();
    }

    private void build() {
        setSizeFull();
        setMargin(true);
        addStyleName("backColorPurple");
        addComponent(tasksLayout);
        setComponentAlignment(tasksLayout, Alignment.TOP_CENTER);
       // addComponent(tasksDisplay);
        //setComponentAlignment(tasksPanel, Alignment.);

    }


}
