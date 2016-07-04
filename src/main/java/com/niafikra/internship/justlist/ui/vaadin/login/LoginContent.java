package com.niafikra.internship.justlist.ui.vaadin.login;

import com.niafikra.internship.justlist.ui.vaadin.login.authentication.AuthenticationPanel;
import com.vaadin.ui.HorizontalLayout;

/**
 * @author Boniface Chacha
 * @email boniface.chacha@niafikra.com
 * @email bonifacechacha@gmail.com
 * @date 6/24/16 5:58 PM
 */
public class LoginContent extends HorizontalLayout{

    private AuthenticationPanel authenticationPanel;
    private WelcomeMessageLayout welcomeView;

    public LoginContent(LoginView components) {
        authenticationPanel = new AuthenticationPanel();
        welcomeView = new WelcomeMessageLayout();


        build();
    }

    private void build() {
        setSizeFull();

        addComponent(welcomeView);
        addComponent(authenticationPanel);

        setExpandRatio(welcomeView,1);
    }

    public AuthenticationPanel getAuthenticationPanel() {
        return authenticationPanel;
    }

    public WelcomeMessageLayout getWelcomeView() {
        return welcomeView;
    }
}
