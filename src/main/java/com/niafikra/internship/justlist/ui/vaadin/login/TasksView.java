package com.niafikra.internship.justlist.ui.vaadin.login;

import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

/**
 * Created by lilianngweta on 7/11/16.
 */
public class TasksView extends VerticalLayout {

    public TasksView(){

        build();
    }

    private void build() {
        setSizeFull();

        addStyleName("backColorPurple");

        Label label = new Label("Tassssssksssss!!!");

        addComponent(label);

    }


}
