package com.niafikra.internship.justlist.ui.vaadin.login;


import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Layout;

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

        addStyleName("backColorWhite");
        addComponent(logo);
        addComponent(logOutLayout);
        addStyleName("marginSetter");
        setMargin(new MarginInfo(false,true,false,false));

        setComponentAlignment(logOutLayout, Alignment.MIDDLE_RIGHT);
    }


}
