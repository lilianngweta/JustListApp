package com.niafikra.internship.justlist.ui.vaadin.login.project.functions;

import com.niafikra.internship.justlist.data.Project;
import com.niafikra.internship.justlist.data.Task;
import com.niafikra.internship.justlist.service.ProjectService;
import com.niafikra.internship.justlist.service.UserService;
import com.niafikra.internship.justlist.ui.vaadin.login.ProjectsView;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.data.util.filter.SimpleStringFilter;
import com.vaadin.event.FieldEvents;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.*;

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
    private TextField searchProjectBar;
    private ProjectsDisplay projectsDisplay;

    public ProjectsDisplay(ProjectsView projectsView) {
        this.projectsView = projectsView;
        projectsDisplay = projectsView.getProjectsDisplay();
        projectService = ProjectService.get();
        container = new BeanItemContainer<Project>(Project.class);

        setSizeFull();
        //setSpacing(true);

        build();
        createProjectGrid();
    }

    public void build() {

        HorizontalLayout searchProject = new HorizontalLayout();
        addComponent(searchProject);
        searchProject.setWidth("100%");
        /**
         *  An input field to use for filter
         */
        searchProjectBar = new TextField();
        searchProjectBar.setInputPrompt("Search project...");
        setSizeFull();
        /**
         * On Change of text, filter the data of the grid
         */
        searchProjectBar.addTextChangeListener(getProjectsListener());

        searchProjectBar.setImmediate(true);
        searchProjectBar.setWidth("100%");
        //setExpandRatio(searchProjectBar,1);
        searchProject.addComponent(searchProjectBar);
        setSpacing(false);

    }


    /**
     * Returns the TextChangeListener that gets triggered
     *
     * @return
     */



    private void createProjectGrid() {
        grid = new Grid(container);
        grid.setSelectionMode(Grid.SelectionMode.MULTI);
        grid.setRowStyleGenerator(new Grid.RowStyleGenerator() {
            @Override
            public String getStyle(Grid.RowReference row) {
                Project project = (Project) row.getItemId();
                return project.isArchived() ? "completed" : "task-not-completed";
            }
        });


        grid.setWidth("100%");
        grid.setSizeFull();
        grid.removeColumn("id");
        grid.removeColumn("user");
        grid.removeColumn("archived");
        addComponent(grid);
        setExpandRatio(grid, 1);

        grid.addItemClickListener(event -> {
            Project project = (Project) event.getItemId();
            setCurrentSelectedProject(project);
        });
    }


    private FieldEvents.TextChangeListener getProjectsListener() {
        return new FieldEvents.TextChangeListener() {

            @Override
            public void textChange(FieldEvents.TextChangeEvent event) {
                String newValue = (String) event.getText();

                /**
                 * This removes the previous filter that was used to filter the container
                 */
                container.removeContainerFilters("name");

                if (null != newValue && !newValue.isEmpty()) {
                    //Set new filter for the "name" column
                    container.addContainerFilter(new SimpleStringFilter(
                            "name", newValue, true, false));
                }
                grid.recalculateColumnWidths();
            }
        };

    }


    public void fetchProjects() {
        container.removeAllItems();
        projectsView.getProjectsDisplay().getContainer().addAll(projectService.getProjects(UserService.get().getCurrentSessionUser()));

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
