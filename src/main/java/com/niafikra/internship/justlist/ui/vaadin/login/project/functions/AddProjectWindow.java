package com.niafikra.internship.justlist.ui.vaadin.login.project.functions;

import com.niafikra.internship.justlist.service.ProjectService;
import com.vaadin.ui.*;

/**
 * Created by lilianngweta on 7/12/16.
 */
public class AddProjectWindow implements Button.ClickListener {

    private TextField textField;
    private Button save;
    private ProjectService projectService;
    private ProjectsDisplay projectsDisplay;

    public AddProjectWindow(ProjectsDisplay projectsDisplay){

        setProjectsDisplay(projectsDisplay);
        textField = new TextField();
        save = new Button("Save");
        projectService = ProjectService.get();
        //project = new Project();

        build();

    }

    private void build() {

        Window window = new Window("Add Project");
        window.setWidth("500px");
        window.setHeight("200px");
        VerticalLayout content = new VerticalLayout();
        content.setWidth("500px");
        content.setSpacing(true);

        content.addComponent(textField);
        textField.setWidth("300px");
        content.setComponentAlignment(textField,Alignment.MIDDLE_CENTER);


        save.addClickListener(this);
        content.addComponent(save);
        content.setComponentAlignment(save, Alignment.MIDDLE_CENTER);

        window.setContent(content);
        window.center();

        UI.getCurrent().addWindow(window);

    }


    @Override
    public void buttonClick(Button.ClickEvent event) {

        boolean result = projectService.save(textField.getValue());

        if(result){


            //removeAllComponents();
            projectsDisplay.fetchProjects();

            //Notification.show("Successfully saved!!");
        }


    }

    public void setProjectsDisplay(ProjectsDisplay projectsDisplay) {
        this.projectsDisplay = projectsDisplay;
    }
}
