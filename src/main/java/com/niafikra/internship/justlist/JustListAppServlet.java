package com.niafikra.internship.justlist;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import com.vaadin.server.VaadinServlet;

@WebServlet(
    asyncSupported=false,
    urlPatterns={"/*","/VAADIN/*"},
    initParams={
        @WebInitParam(name="ui", value="com.niafikra.internship.justlist.JustListAppUI")
    })
public class JustListAppServlet extends VaadinServlet { }
