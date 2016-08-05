package com.niafikra.internship.justlist.ui.vaadin.login;

import com.vaadin.ui.HorizontalLayout;

/**
 * Created by lilianngweta on 7/11/16.
 */
public class TasksContent extends HorizontalLayout {

    private ProjectsView projectsView;
    private TasksView tasksView;

    public TasksContent(){

        projectsView = new ProjectsView(this);
        tasksView = new TasksView(this);
        build();
    }

    private void build() {
        setSizeFull();
        addComponent(projectsView);
        addComponent(tasksView);
        //addStyleName("backColorAqua");

        //projectsView.addStyleName("backColorAqua");
        setExpandRatio(tasksView,3);
        setExpandRatio(projectsView,1);
        setStyleName("backgroundimage");

    }

    public ProjectsView getProjectsView() {
        return projectsView;
    }

    public TasksView getTasksView() {
        return tasksView;
    }
}
