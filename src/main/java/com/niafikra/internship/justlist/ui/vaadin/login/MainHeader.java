package com.niafikra.internship.justlist.ui.vaadin.login;


import com.vaadin.ui.Alignment;
import com.vaadin.ui.HorizontalLayout;

/**
 * Created by lilianngweta on 7/8/16.
 *
 */
public class MainHeader extends HorizontalLayout {

    private LogOut logOut;
    private Logo logo;

    public MainHeader(){

        logOut = new LogOut();
        logo = new Logo();

        addComponent(logo);
        logo.addComponent(logOut);
        logo.setWidth("1450px");

        logo.setComponentAlignment(logOut, Alignment.MIDDLE_RIGHT);


    }





}
