package com.niafikra.internship.justlist.ui.vaadin.login.project.functions;
import com.niafikra.internship.justlist.ui.vaadin.login.ProjectsView;
import com.vaadin.data.util.filter.SimpleStringFilter;
import com.vaadin.event.FieldEvents;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;

/**
 * Created by lilianngweta on 7/11/16.
 */
public class ProjectsHeader extends HorizontalLayout {

    private TextField searchProjectBar;
    private Button addProjectButton;
    private AddProjectWindow addProjectWindow;
    private ProjectsView projectsView;
    private ProjectsDisplay projectsDisplay;

    public ProjectsHeader(ProjectsView projectsView) {
        this.projectsView = projectsView;

        /**
         *  An input field to use for filter
         */
        searchProjectBar = new TextField();

        addProjectButton = new Button("Add");
        projectsDisplay = projectsView.getProjectsDisplay();


        searchProjectBar.setInputPrompt("Search project...");

        build();
    }

    private void build() {


        /**
         * On Change of text, filter the data of the grid
         */
        searchProjectBar.addTextChangeListener(getProjectsListener());

        searchProjectBar.setImmediate(true);

        //searchProjectBar.setWidth("100px");
        addComponent(searchProjectBar);


        addComponent(addProjectButton);

        setSpacing(true);

        addProjectButton.addClickListener(event -> {
            addProjectWindow = new AddProjectWindow(projectsView.getProjectsDisplay());
        });

    }

    /**
     * Returns the TextChangeListener that gets triggered
     *
     * @return
     */
    private FieldEvents.TextChangeListener getProjectsListener() {
        return new FieldEvents.TextChangeListener() {

            @Override
            public void textChange(FieldEvents.TextChangeEvent event) {
                String newValue = (String) event.getText();

                /**
                 * This removes the previous filter that was used to filter the container
                 */
                projectsDisplay.getContainer().removeContainerFilters("name");

                if (null != newValue && !newValue.isEmpty()) {
                    //Set new filter for the "name" column
                    projectsDisplay.getContainer().addContainerFilter(new SimpleStringFilter(
                            "name", newValue, true, false));
                }
                projectsDisplay.getGrid().recalculateColumnWidths();
            }
        };

    }


}


