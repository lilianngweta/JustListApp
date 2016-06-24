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
    private WelcomeLayout welcomeLayout;

    public LoginContent(BaseLoginLayout components) {
        authenticationPanel = new AuthenticationPanel();
        welcomeLayout = new WelcomeLayout();


        build();
    }

    private void build() {
        setSizeFull();

        addComponent(welcomeLayout);
        addComponent(authenticationPanel);

        setExpandRatio(welcomeLayout,1);
    }

    public AuthenticationPanel getAuthenticationPanel() {
        return authenticationPanel;
    }

    public WelcomeLayout getWelcomeLayout() {
        return welcomeLayout;
    }
}
