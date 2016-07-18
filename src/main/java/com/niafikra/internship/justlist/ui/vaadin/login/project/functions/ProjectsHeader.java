package com.niafikra.internship.justlist.ui.vaadin.login.project.functions;

import com.niafikra.internship.justlist.ui.vaadin.login.ProjectsView;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;

/**
 * Created by lilianngweta on 7/11/16.
 */
public class ProjectsHeader extends HorizontalLayout{

    private TextField searchBar;
    private Button addProjectButton;
    private AddProjectWindow addProjectWindow;
    private ProjectsView projectsView;

    public ProjectsHeader(ProjectsView projectsView){
        this.projectsView=projectsView;

        searchBar = new TextField();
        addProjectButton = new Button("Add");


        build();
    }

    private void build() {

        //searchBar.setWidth("100px");
        addComponent(searchBar);

        //addProjectButton.setWidth("50px");
        addComponent(addProjectButton);

        setSpacing(true);

       addProjectButton.addClickListener(event -> {
           addProjectWindow = new AddProjectWindow(projectsView.getProjectsDisplay());
       });


    }

}
