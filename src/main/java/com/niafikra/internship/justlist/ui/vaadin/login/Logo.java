package com.niafikra.internship.justlist.ui.vaadin.login;

import com.vaadin.server.ThemeResource;
import com.vaadin.ui.Image;

/**
 * Created by lilianngweta on 7/8/16.
 */
public class Logo extends Image{

    public Logo() {
        super(null,new ThemeResource("Logo.png"));
        setWidth("100px");
    }

}
