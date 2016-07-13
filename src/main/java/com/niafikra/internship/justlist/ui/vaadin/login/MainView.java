package com.niafikra.internship.justlist.ui.vaadin.login;

import com.niafikra.internship.justlist.JustListAppUI;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.Resource;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.*;

/**
 * Created by lilianngweta on 7/1/16.
 */
public class MainView extends VerticalLayout implements View {

    private MainHeader mainHeader;
    private TasksContent tasksContent;

    public MainView(){

        mainHeader = new MainHeader();
        tasksContent = new TasksContent();

        addComponent(mainHeader);
        addComponent(tasksContent);

        setSizeFull();

        setExpandRatio(tasksContent,1);

    }


    public MainHeader getMainHeader() {
        return mainHeader;
    }

    public TasksContent getTasksContent() {
        return tasksContent;
    }

    @Override

    public void enter(ViewChangeListener.ViewChangeEvent event) {


    }
}
