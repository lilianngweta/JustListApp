package com.niafikra.internship.justlist.Views;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;

/**
 * Created by lilianngweta on 7/1/16.
 */
public class TasksView extends VerticalLayout implements View {

    public TasksView() {

        setSizeFull();


    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {

        Notification.show("Welcome User!");

    }
}
