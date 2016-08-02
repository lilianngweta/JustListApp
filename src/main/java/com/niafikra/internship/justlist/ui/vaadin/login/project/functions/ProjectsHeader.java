package com.niafikra.internship.justlist.ui.vaadin.login.project.functions;
import com.niafikra.internship.justlist.data.Project;
import com.niafikra.internship.justlist.service.ProjectService;
import com.niafikra.internship.justlist.service.UserService;
import com.niafikra.internship.justlist.ui.vaadin.login.ProjectsView;
import com.vaadin.data.util.filter.SimpleStringFilter;
import com.vaadin.event.FieldEvents;
import com.vaadin.ui.Button;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;

import java.util.Collection;

/**
 * Created by lilianngweta on 7/11/16.
 */
public class ProjectsHeader extends HorizontalLayout {

    private ProjectsView projectsView;
    private ProjectService projectService;
    private AddProjectWindow addProjectWindow;


    public ProjectsHeader(ProjectsView projectsView) {
        this.projectsView = projectsView;
        projectService = ProjectService.get();

        createProjectsActions();
    }

    private void createProjectsActions() {
        //HorizontalLayout actions = new HorizontalLayout();
        //addComponent(actions);
        Button deleteButton = new Button("Delete");
        deleteButton.addClickListener(event -> {
            Collection selectedProjectIDs= projectsView.getProjectsDisplay().getGrid().getSelectedRows();
            for (Object selectedProjectID : selectedProjectIDs) {
                projectService.delete((Project) selectedProjectID);
                projectsView.getProjectsDisplay().getGrid().deselect(selectedProjectID);
            }

            projectsView.getProjectsDisplay().fetchProjects();

            if(selectedProjectIDs.contains(projectsView.getProjectsDisplay().getCurrentSelectedProject()))
                projectsView.getProjectsDisplay().setCurrentSelectedProject(null);
        });
        addComponent(deleteButton);

        Button completeButton = new Button("Archive");
        completeButton.addClickListener(event -> {
            Collection selectedProjectIDs= projectsView.getProjectsDisplay().getGrid().getSelectedRows();
            for (Object selectedProjectID : selectedProjectIDs) {
                projectService.archive((Project) selectedProjectID);
                projectsView.getProjectsDisplay().getGrid().deselect(selectedProjectID);
                projectsView.getProjectsDisplay().getGrid().getRowStyleGenerator();
            }
            projectsView.getProjectsDisplay().fetchProjects();
        });
        addComponent(completeButton);

        Button addProjectButton = new Button("Add Project");
        addProjectButton.addClickListener(event -> {
            addProjectWindow = new AddProjectWindow(projectsView.getProjectsDisplay());
        });

        addComponent(addProjectButton);
    }


    public void setRowStyleGenerator(Grid.RowStyleGenerator rowStyleGenerator){

       // rowStyleGenerator.getStyle()

    }


}


