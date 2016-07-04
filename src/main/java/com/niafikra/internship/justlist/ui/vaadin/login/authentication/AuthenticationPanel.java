package com.niafikra.internship.justlist.ui.vaadin.login.authentication;

import com.vaadin.ui.VerticalLayout;

/**
 * Created by lilianngweta on 6/24/16.
 */
public class AuthenticationPanel extends VerticalLayout {

    private LogInForm logInForm;
    private RegisterForm registerForm;

    public AuthenticationPanel() {
        logInForm = new LogInForm();
        registerForm = new RegisterForm();

        build();
        showLogin();
    }

    private void build() {
        setWidth("400px");
        setHeight("800px");
       // addStyleName("backColorBrown");
    }

    public void showLogin() {
        removeAllComponents();
        addComponent(logInForm);
    }

    public void showRegister() {
        removeAllComponents();
        addComponent(registerForm);
    }
}
