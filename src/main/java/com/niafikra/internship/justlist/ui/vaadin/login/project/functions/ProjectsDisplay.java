package com.niafikra.internship.justlist.ui.vaadin.login.project.functions;

import com.niafikra.internship.justlist.data.Project;
import com.niafikra.internship.justlist.service.ProjectService;
import com.niafikra.internship.justlist.service.UserService;
import com.niafikra.internship.justlist.ui.vaadin.login.ProjectsView;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.ui.Button;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.VerticalLayout;

import java.util.Collection;

/**
 * Created by lilianngweta on 7/15/16.
 */
public class ProjectsDisplay extends VerticalLayout {

    // private static ProjectsView projectView;
    private ProjectService projectService;
    private BeanItemContainer<Project> container;
    private Project currentSelectedProject;
    private ProjectsView projectsView;
    private Grid grid;

    public ProjectsDisplay(ProjectsView projectsView) {
        this.projectsView = projectsView;

        projectService = ProjectService.get();
        container = new BeanItemContainer<Project>(Project.class);

        setSizeFull();
        setSpacing(true);
        /**
         * Create a grid
         */
        createProjectsActions();
        createProjectGrid();
    }

    private void createProjectsActions() {
        HorizontalLayout actions = new HorizontalLayout();
        addComponent(actions);
        Button deleteButton = new Button("Delete");
        deleteButton.addClickListener(event -> {
            Collection selectedProjectIDs= grid.getSelectedRows();
            for (Object selectedTaskID : selectedProjectIDs)
                projectService.delete((Project) selectedTaskID);

            fetchProjects();

            if(selectedProjectIDs.contains(currentSelectedProject))
                setCurrentSelectedProject(null);
        });
        actions.addComponent(deleteButton);

        Button completeButton = new Button("Archive");
        completeButton.addClickListener(event -> {
            for (Object selectedTaskID : grid.getSelectedRows())
                projectService.archive((Project)selectedTaskID);

            fetchProjects();
        });
        actions.addComponent(completeButton);
    }

    private void createProjectGrid() {
        grid = new Grid(container);
        grid.setSelectionMode(Grid.SelectionMode.MULTI);
        grid.setWidth("100%");
        grid.setSizeFull();
        grid.removeColumn("id");
        grid.removeColumn("user");
        addComponent(grid);
        setExpandRatio(grid, 1);

        grid.addItemClickListener(event -> {
            Project project = (Project) event.getItemId();
            setCurrentSelectedProject(project);
        });
    }

    public void fetchProjects() {
        container.removeAllItems();
        container.addAll(projectService.getProjects(UserService.get().getCurrentSessionUser()));

    }

    public void setCurrentSelectedProject(Project currentSelectedProject) {
        this.currentSelectedProject = currentSelectedProject;
        projectsView.getTasksContent().getTasksView().setCurrentProject(currentSelectedProject);
    }

    public Project getCurrentSelectedProject() {
        return currentSelectedProject;
    }

    public Grid getGrid() {
        return grid;
    }

    public BeanItemContainer<Project> getContainer() {
        return container;
    }
}
