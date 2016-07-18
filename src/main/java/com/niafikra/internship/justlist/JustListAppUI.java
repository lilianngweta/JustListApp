package com.niafikra.internship.justlist;

import com.niafikra.internship.justlist.ui.vaadin.login.LoginExtension;
import com.niafikra.internship.justlist.ui.vaadin.login.LoginView;
import com.niafikra.internship.justlist.ui.vaadin.login.MainView;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;
import com.vaadin.annotations.Theme;

@Theme("JustListApp")
public class JustListAppUI extends UI {

    private  Navigator navigator;

    private LoginView loginView;
    private MainView mainView;


    @Override
    protected void init(VaadinRequest request) {

        loginView = new LoginView();
        mainView=new MainView();

        navigator = new Navigator(this,this);
        navigator.addView("",loginView);
        navigator.addView("main",mainView);
        navigator.addView("login", new LoginExtension());

    }

    public LoginView getLoginView() {
        return loginView;
    }

    public MainView getMainView() {
        return mainView;
    }

    @Override
    public Navigator getNavigator() {
        return navigator;
    }
}
