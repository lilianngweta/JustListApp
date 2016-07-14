package com.niafikra.internship.justlist.ui.vaadin.login;
import com.niafikra.internship.justlist.ui.vaadin.login.task.functions.TasksLayout;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.VerticalLayout;

/**
 * Created by lilianngweta on 7/11/16.
 */
public class TasksView extends HorizontalLayout {

    private TasksLayout tasksLayout;

    public TasksView(){

        tasksLayout = new TasksLayout();
        build();
    }

    private void build() {
        setSizeFull();
        setMargin(true);
        addStyleName("backColorPurple");
        addComponent(tasksLayout);
        setComponentAlignment(tasksLayout, Alignment.TOP_CENTER);
        //setComponentAlignment(tasksPanel, Alignment.);

    }


}
