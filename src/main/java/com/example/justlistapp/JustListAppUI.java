package com.example.justlistapp;

import com.vaadin.server.ThemeResource;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;
import com.vaadin.ui.Label;
import com.vaadin.annotations.Theme;
//package com.example.todolist;

import com.vaadin.server.Resource;
//import com.vaadin.ui.UI;
//import com.vaadin.ui.Label;
//import com.vaadin.annotations.Theme;
//import com.vaadin.ui.TextField;
import com.vaadin.ui.Button;
//import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.*;
//import com.mysql.MysqlJavaConnector;
//import java.sql.*;
//import java.sql.Connection;

@Theme("JustListApp")
public class JustListAppUI extends UI {

	@Override
	protected void init(VaadinRequest request) {


		VerticalLayout main = new VerticalLayout();
		setContent(main);
		main.setSizeFull();

		HorizontalLayout header = new HorizontalLayout();
        header.setWidth("100%");
		main.addComponent(header);

		//Label logo = new Label("JustList");
		//layout.addComponent(logo);



        // Serve the image from the theme
        Resource res = new ThemeResource("Logo.png");

        // Display the image without caption
        Image image = new Image(null, res);

        image.setWidth("100px");
        image.setHeight("100px");
        header.addComponent(image);
        header.setComponentAlignment(image,Alignment.TOP_LEFT);


        header.addStyleName("backColorWhite");

        HorizontalLayout account = new HorizontalLayout();
        account.setWidth("500px");
        header.addComponent(account);
		header.setComponentAlignment(account,Alignment.TOP_RIGHT);



		Button logIn = new Button("Sign");
        logIn.setWidth("150px");
		account.addComponent(logIn);
		account.setComponentAlignment(logIn, Alignment.TOP_RIGHT);

		Button signUp = new Button("Create an account");
        signUp.setWidth("200px");
		account.addComponent(signUp);
		account.setComponentAlignment(signUp, Alignment.TOP_RIGHT);

        account.setMargin(true);

		HorizontalLayout lowerLoyout = new HorizontalLayout();
       // lowerLoyout.setWidth("100%");
        lowerLoyout.setSizeFull();
        main.addComponent(lowerLoyout);
        //lowerLoyout.addStyleName("backColorBrown");

        VerticalLayout loginRegisterArea = new VerticalLayout();
        loginRegisterArea.setWidth("800px");
        loginRegisterArea.setHeight("800px");
        lowerLoyout.addComponent(loginRegisterArea);
        lowerLoyout.setComponentAlignment(loginRegisterArea,Alignment.TOP_RIGHT);
        loginRegisterArea.addStyleName("backColorBrown");



		logIn.addClickListener(e -> {

            LogIn login = new LogIn();



            // login form, centered in the available part of the screen
            Component loginForm = login.buildLoginForm();

            // layout to center login form when there is sufficient screen space
            // - see the theme for how this is made responsive for various screen
            // sizes
            //VerticalLayout centeringLayout = new VerticalLayout();

            loginRegisterArea.addComponent(loginForm);
            loginRegisterArea.setComponentAlignment(loginForm,
                    Alignment.TOP_RIGHT);


          //  addComponent(centeringLayout);



		});


		signUp.addClickListener(e -> {

            Register signup = new Register();

            Component registerForm = signup.buildRegisterForm();

            loginRegisterArea.addComponent(registerForm);
            loginRegisterArea.setComponentAlignment(registerForm,
                    Alignment.TOP_RIGHT);


		});


	}


}
