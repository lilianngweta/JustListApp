package com.niafikra.internship.justlist.ui.vaadin.login;
import com.niafikra.internship.justlist.data.Project;
import com.niafikra.internship.justlist.ui.vaadin.login.task.functions.TasksDisplay;
import com.niafikra.internship.justlist.ui.vaadin.login.task.functions.TasksHeader;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.VerticalLayout;

/**
 * Created by lilianngweta on 7/11/16.
 */
public class TasksView extends VerticalLayout {

    private TasksHeader tasksHeader;
    private TasksDisplay tasksDisplay;
    private TasksContent tasksContent;

    public TasksView(TasksContent tasksContent) {
        this.tasksContent=tasksContent;

        tasksDisplay = new TasksDisplay();
        tasksHeader = new TasksHeader(tasksDisplay);

        build();
    }

    private void build() {
        setSizeFull();
        setMargin(true);
        addStyleName("backColorPurple");
        addComponent(tasksHeader);
        setComponentAlignment(tasksHeader, Alignment.TOP_CENTER);
        addComponent(tasksDisplay);
        //setComponentAlignment(tasksPanel, Alignment.);
        setExpandRatio(tasksDisplay,5);
        setExpandRatio(tasksHeader,1);

    }

    public TasksHeader getTasksLayout() {
        return tasksHeader;
    }

    public TasksDisplay getTasksDisplay() {
        return tasksDisplay;
    }

    public void setCurrentProject(Project currentSelectedProject) {
        tasksHeader.setCurrentProject(currentSelectedProject);
        tasksDisplay.setCurrentProject(currentSelectedProject);
    }
}
