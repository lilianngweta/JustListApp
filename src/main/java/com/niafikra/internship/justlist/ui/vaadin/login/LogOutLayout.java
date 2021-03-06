package com.niafikra.internship.justlist.ui.vaadin.login;

import com.niafikra.internship.justlist.JustListAppUI;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;

/**
 * Created by lilianngweta on 7/8/16.
 */
public class LogOutLayout extends HorizontalLayout{

    public LogOutLayout(){

        build();

    }


    private void build(){

        Button button = new Button("Logout",
                new Button.ClickListener() {
                    @Override
                    public void buttonClick(Button.ClickEvent event) {

                        JustListAppUI justListAppUI = (JustListAppUI) getUI();
                        justListAppUI.getNavigator().navigateTo("");

                    }
                });
        button.setDisableOnClick(false);
        button.setWidth("180px");
        addComponent(button);
        setComponentAlignment(button, Alignment.MIDDLE_RIGHT);
    }

}
