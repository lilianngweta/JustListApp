package com.niafikra.internship.justlist.ui.vaadin.login.project.functions;
import com.niafikra.internship.justlist.data.Project;
import com.niafikra.internship.justlist.service.ProjectService;
import com.niafikra.internship.justlist.service.UserService;
import com.niafikra.internship.justlist.ui.vaadin.login.ProjectsView;
import com.vaadin.data.util.filter.SimpleStringFilter;
import com.vaadin.event.FieldEvents;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.*;

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
       // setMargin(new MarginInfo(false,true,false,false));
    }

    private void createProjectsActions() {
        setSizeFull();
        HorizontalLayout projectActions = new HorizontalLayout();
        addComponent(projectActions);
        projectActions.setSizeFull();
        setComponentAlignment(projectActions, Alignment.BOTTOM_LEFT);
        Button deleteButton = new Button("Delete");
        deleteButton.setWidth("100%");
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
        projectActions.addComponent(deleteButton);

        Button completeButton = new Button("Archive");
        completeButton.setWidth("100%");
        completeButton.addClickListener(event -> {
            Collection selectedProjectIDs= projectsView.getProjectsDisplay().getGrid().getSelectedRows();
            for (Object selectedProjectID : selectedProjectIDs) {
                projectService.archive((Project) selectedProjectID);
                projectsView.getProjectsDisplay().getGrid().deselect(selectedProjectID);
                projectsView.getProjectsDisplay().getGrid().getRowStyleGenerator();
            }
            projectsView.getProjectsDisplay().fetchProjects();
        });
        projectActions.addComponent(completeButton);

        Button addProjectButton = new Button("Add Project");
        addProjectButton.setWidth("100%");
        addProjectButton.addClickListener(event -> {
            addProjectWindow = new AddProjectWindow(projectsView.getProjectsDisplay());
        });

        projectActions.addComponent(addProjectButton);
    }


}


