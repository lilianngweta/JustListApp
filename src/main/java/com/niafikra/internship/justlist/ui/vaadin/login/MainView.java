package com.niafikra.internship.justlist.ui.vaadin.login;

import com.niafikra.internship.justlist.JustListAppUI;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

/**
 * Created by lilianngweta on 7/1/16.
 */
public class MainView extends VerticalLayout implements View {

    public MainView(){
        setSizeFull();



        Button button = new Button("Logout",
                new Button.ClickListener() {
                    @Override
                    public void buttonClick(Button.ClickEvent event) {

                        JustListAppUI justListAppUI = (JustListAppUI) getUI();
                        justListAppUI.getNavigator().navigateTo("");

                    }
                });
        button.setDisableOnClick(false);
        addComponent(button);
        setComponentAlignment(button, Alignment.MIDDLE_CENTER);
    }






    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {

        //addComponent(new Label("WE ARE INSIDE"));
    }
}
