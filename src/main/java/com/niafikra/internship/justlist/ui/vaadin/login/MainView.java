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

    public MainView(){

        mainHeader = new MainHeader();

        addComponent(mainHeader);

        setSizeFull();





        //build();
    }










    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {

        //addComponent(new Label("WE ARE INSIDE"));
    }
}
