package com.niafikra.internship.justlist.ui.vaadin.login.project.functions;

import com.niafikra.internship.justlist.service.ProjectService;
import com.niafikra.internship.justlist.service.UserService;
import com.vaadin.ui.*;

/**
 * Created by lilianngweta on 7/12/16.
 */
public class AddProjectWindow extends Window implements Button.ClickListener {

    private TextField textField;
    private Button saveProjectButton;
    private ProjectService projectService;
    private ProjectsDisplay projectsDisplay;

    public AddProjectWindow(ProjectsDisplay projectsDisplay){

        setProjectsDisplay(projectsDisplay);
        textField = new TextField();
        saveProjectButton = new Button("Save");
        projectService = ProjectService.get();

        build();

    }

    private void build() {

        setWidth("500px");
        setHeight("200px");
        VerticalLayout content = new VerticalLayout();
        content.setWidth("500px");
        content.setSpacing(true);

        content.addComponent(textField);
        textField.setWidth("300px");
        content.setComponentAlignment(textField,Alignment.MIDDLE_CENTER);


        saveProjectButton.addClickListener(this);
        content.addComponent(saveProjectButton);
        content.setComponentAlignment(saveProjectButton, Alignment.MIDDLE_CENTER);

        setContent(content);
        center();

        UI.getCurrent().addWindow(this);

    }


    @Override
    public void buttonClick(Button.ClickEvent event) {

        boolean result = projectService.save(textField.getValue(), UserService.get().getCurrentSessionUser());

        if(result){

            projectsDisplay.fetchProjects();
            close();
            //Notification.show("Successfully saved!!");
        }

    }

    public void setProjectsDisplay(ProjectsDisplay projectsDisplay) {
        this.projectsDisplay = projectsDisplay;
    }
}
