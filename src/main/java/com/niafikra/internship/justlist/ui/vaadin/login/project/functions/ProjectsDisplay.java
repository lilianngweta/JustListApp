package com.niafikra.internship.justlist.ui.vaadin.login.project.functions;

import com.niafikra.internship.justlist.data.Project;
import com.niafikra.internship.justlist.service.ProjectService;
import com.niafikra.internship.justlist.service.UserService;
import com.niafikra.internship.justlist.ui.vaadin.login.ProjectsView;
import com.vaadin.data.Item;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.data.util.GeneratedPropertyContainer;
import com.vaadin.data.util.PropertyValueGenerator;
import com.vaadin.event.SelectionEvent;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.renderers.ButtonRenderer;

/**
 * Created by lilianngweta on 7/15/16.
 */
public class ProjectsDisplay extends HorizontalLayout {

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

        /**
         * Generate button caption column
         */
        GeneratedPropertyContainer gpc = new GeneratedPropertyContainer(container);

        gpc.addGeneratedProperty("delete",
                new PropertyValueGenerator<String>() {

                    @Override
                    public String getValue(Item item, Object itemId, Object propertyId) {
                        return "Delete"; // The caption
                    }

                    @Override
                    public Class<String> getType() {
                        return String.class;
                    }
                });



        /**
         * Create a grid
         */
        grid = new Grid(gpc);

        /*Render a button that deletes the data row (item)*/
        grid.getColumn("delete").setRenderer(new ButtonRenderer(e -> {
            Project project= (Project) e.getItemId();
            grid.getContainerDataSource().removeItem(e.getItemId());
            projectService.delete(project);
            projectsView.getProjectsDisplay().getContainer().removeAllItems();
        }));

        grid.removeColumn("id");
        grid.removeColumn("user");
        grid.addSelectionListener(new SelectionEvent.SelectionListener() {

            @Override
            public void select(SelectionEvent event) {
                Object selected = ((Grid.SingleSelectionModel)
                        grid.getSelectionModel()).getSelectedRow();

                if (selected == null) return;

                currentSelectedProject = (Project) selected;
                projectsView.getTasksContent().getTasksView().setCurrentProject(currentSelectedProject);

            }
        });
        addComponent(grid);

        setSizeFull();

        //grid.sort("name", SortDirection.DESCENDING);
        grid.setWidth("100%");
        grid.setSizeFull();

    }

    public void fetchProjects() {

        container.removeAllItems();
        container.addAll(projectService.getProjects(UserService.get().getCurrentSessionUser()));

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
