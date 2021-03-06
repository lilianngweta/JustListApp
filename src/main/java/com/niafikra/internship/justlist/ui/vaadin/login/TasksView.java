package com.niafikra.internship.justlist.ui.vaadin.login;
import com.niafikra.internship.justlist.data.Project;
import com.niafikra.internship.justlist.ui.vaadin.login.project.functions.AddProjectWindow;
import com.niafikra.internship.justlist.ui.vaadin.login.task.functions.AddTaskWindow;
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

        tasksDisplay = new TasksDisplay(this);
        tasksHeader = new TasksHeader(this);

        build();
    }

    private void build() {
        setSizeFull();
        setMargin(false);
        setSpacing(true);
       // addStyleName("backColorPurple");
        addComponent(tasksHeader);
        setComponentAlignment(tasksHeader, Alignment.TOP_CENTER);
        addComponent(tasksDisplay);
        setExpandRatio(tasksDisplay,10);
        setExpandRatio(tasksHeader,1);

    }

    public TasksHeader getTasksHeader() {
        return tasksHeader;
    }

    public TasksDisplay getTasksDisplay() {
        return tasksDisplay;
    }

    public TasksContent getTasksContent() {
        return tasksContent;
    }

   public void setCurrentProject(Project currentSelectedProject) {
       tasksDisplay.setCurrentProject(currentSelectedProject);
    }


}
