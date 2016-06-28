package com.niafikra.internship.justlist;

import com.niafikra.internship.justlist.ui.vaadin.login.BaseLoginLayout;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;
import com.vaadin.annotations.Theme;
//package com.example.todolist;

//import com.vaadin.ui.UI;
//import com.vaadin.ui.Label;
//import com.vaadin.annotations.Theme;
//import com.vaadin.ui.TextField;
//import com.vaadin.ui.FormLayout;

//import com.mysql.MysqlJavaConnector;
//import java.sql.*;
//import java.sql.Connection;

@Theme("JustListApp")
public class JustListAppUI extends UI {

    @Override
    protected void init(VaadinRequest request) {

        BaseLoginLayout loginLayout = new BaseLoginLayout();
        setContent(loginLayout);

    }


}
