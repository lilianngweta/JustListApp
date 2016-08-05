package com.niafikra.internship.justlist.ui.vaadin.login;

import com.niafikra.internship.justlist.ui.vaadin.login.project.functions.ProjectsDisplay;
import com.niafikra.internship.justlist.ui.vaadin.login.project.functions.ProjectsHeader;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.Alignment;
//import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

/**
 * Created by lilianngweta on 7/11/16.
 */
public class ProjectsView extends VerticalLayout {

    private ProjectsDisplay projectsDisplay;
    private ProjectsHeader projectsHeader;
    private TasksContent tasksContent;


    public ProjectsView(TasksContent tasksContent) {
        this.tasksContent = tasksContent;

        projectsDisplay = new ProjectsDisplay(this);
        projectsHeader = new ProjectsHeader(this);
        build();
    }

    private void build() {

        setSizeFull();
        setMargin(new MarginInfo(false,true,false,false));
        //addStyleName("backColorAqua");
        //setMargin(false);


        addComponent(projectsHeader);
        setComponentAlignment(projectsHeader, Alignment.TOP_CENTER);
        addComponent(projectsDisplay);
        setExpandRatio(projectsDisplay, 10);
        setExpandRatio(projectsHeader, 1);

        setSpacing(true);

    }

    public TasksContent getTasksContent() {
        return tasksContent;
    }

    public ProjectsDisplay getProjectsDisplay() {
        return projectsDisplay;
    }

    public ProjectsHeader getProjectsHeader() {
        return projectsHeader;
    }
}
