package com.niafikra.internship.justlist.ui.vaadin.login.project.functions;

import com.niafikra.internship.justlist.data.Project;
import com.niafikra.internship.justlist.service.ProjectService;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;

/**
 * Created by lilianngweta on 7/15/16.
 */
public class ProjectsDisplay extends HorizontalLayout {

    private ProjectService projectService;
    private BeanItemContainer<Project> container;

    public ProjectsDisplay(){

        projectService = new ProjectService();
        container = new BeanItemContainer<Project>(Project.class);

        Grid grid = new Grid(container);
        addComponent(grid);

        setSizeFull();

        grid.setWidth("100%");
        grid.setSizeFull();

        fetchProjects();

    }

    public void fetchProjects() {

        container.removeAllItems();
        container.addAll(projectService.getProjects());

    }
}
