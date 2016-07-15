package com.niafikra.internship.justlist.ui.vaadin.login;

import com.niafikra.internship.justlist.ui.vaadin.login.project.functions.ProjectsDisplay;
import com.niafikra.internship.justlist.ui.vaadin.login.project.functions.ProjectsHeader;
import com.vaadin.ui.Alignment;
//import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

/**
 * Created by lilianngweta on 7/11/16.
 */
public class ProjectsView extends VerticalLayout {

    private ProjectsDisplay projectsDisplay;
    private ProjectsHeader projectsHeader;

    public ProjectsView(){

        projectsDisplay = new ProjectsDisplay();
        projectsHeader = new ProjectsHeader(projectsDisplay);
        build();
    }

    private void build() {

        setMargin(true);
        setSizeFull();
        addStyleName("backColorAqua");

        addComponent(projectsHeader);
        setComponentAlignment(projectsHeader, Alignment.TOP_CENTER);
        addComponent(projectsDisplay);
        setExpandRatio(projectsDisplay,5);
        setExpandRatio(projectsHeader,1);


    }


    public ProjectsDisplay getProjectsDisplay() {
        return projectsDisplay;
    }

    public ProjectsHeader getProjectsHeader() {
        return projectsHeader;
    }
}
