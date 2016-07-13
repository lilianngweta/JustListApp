package com.niafikra.internship.justlist.ui.vaadin.login;

import com.vaadin.server.Resource;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;

/**
 * Created by lilianngweta on 7/8/16.
 */
public class Logo extends HorizontalLayout {

    public Logo(){

        //setSizeFull();

        build();

    }


    private void build() {

        setMargin(true);
        setWidth("100%");
        addStyleName("backColorWhite");
        //setSizeFull();

        putLogo();

    }


    private void putLogo() {

        Resource resource = new ThemeResource("Logo.png");

        // Display the image without caption
        Image image = new Image(null, resource);

        image.setWidth("100px");
        image.setHeight("100px");
        addComponent(image);
        setComponentAlignment(image, Alignment.TOP_LEFT);
    }



}
