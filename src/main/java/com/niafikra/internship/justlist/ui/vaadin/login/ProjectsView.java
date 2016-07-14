package com.niafikra.internship.justlist.ui.vaadin.login;

import com.niafikra.internship.justlist.ui.vaadin.login.project.functions.SearchAdd;
import com.vaadin.ui.Alignment;
//import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

/**
 * Created by lilianngweta on 7/11/16.
 */
public class ProjectsView extends VerticalLayout {

    private SearchAdd searchAdd;

    public ProjectsView(){

        searchAdd = new SearchAdd();
        build();
    }

    private void build() {

        setMargin(true);
        setSizeFull();
        addStyleName("backColorAqua");

        addComponent(searchAdd);
        setComponentAlignment(searchAdd, Alignment.TOP_CENTER);

    }


}
