package com.niafikra.internship.justlist.ui.vaadin.login;


import com.vaadin.ui.Alignment;
import com.vaadin.ui.HorizontalLayout;

/**
 * Created by lilianngweta on 7/8/16.
 *
 */
public class MainHeader extends HorizontalLayout {

    private LogOutLayout logOutLayout;
    private Logo logo;

    public MainHeader(){
        setWidth("100%");
        logOutLayout = new LogOutLayout();
        logo = new Logo();

        addComponent(logo);
        addComponent(logOutLayout);

        setComponentAlignment(logOutLayout, Alignment.MIDDLE_RIGHT);
    }


}
