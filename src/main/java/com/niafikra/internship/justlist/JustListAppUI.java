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

    @Override
    protected void init(VaadinRequest request) {

        navigator = new Navigator(this,this);
        navigator.addView("",new LoginView());
        navigator.addView("main",new MainView());
        navigator.addView("login", new LoginExtension());

    }

    @Override
    public Navigator getNavigator() {
        return navigator;
    }
}
