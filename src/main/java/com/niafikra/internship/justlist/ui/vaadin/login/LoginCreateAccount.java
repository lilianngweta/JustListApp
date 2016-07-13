package com.niafikra.internship.justlist.ui.vaadin.login;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;

/**
 * Created by lilianngweta on 7/9/16.
 */
public class LoginCreateAccount extends HorizontalLayout {

    private LoginView loginView;
    
    public LoginCreateAccount(LoginView loginView) {
        this.loginView = loginView;

     build();

    }



    private void build() {
        setWidth("100%");
        putAuthenticationButtons();

    }

    private void putAuthenticationButtons() {
        // Serve the image from the theme
        //HorizontalLayout authenticationLayout = new HorizontalLayout();
        setWidth("500px");
        setMargin(true);

        //addComponent(authenticationLayout);
        //setComponentAlignment(authenticationLayout, Alignment.TOP_RIGHT);


        Button logIn = new Button("Sign In");
        logIn.setWidth("150px");
        addComponent(logIn);
        setComponentAlignment(logIn, Alignment.TOP_RIGHT);

        Button signUp = new Button("Create an account");
        signUp.setWidth("200px");
        addComponent(signUp);
        setComponentAlignment(signUp, Alignment.TOP_RIGHT);

        logIn.addClickListener(e -> {
            loginView.getLoginContent().getAuthenticationPanel().showLogin();
        });


        signUp.addClickListener(e -> {
            loginView.getLoginContent().getAuthenticationPanel().showRegister();
        });

    }


}
