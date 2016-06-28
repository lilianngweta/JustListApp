package com.niafikra.internship.justlist.ui.vaadin.login;

import com.vaadin.server.Resource;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.*;

/**
 * @author Boniface Chacha
 * @email boniface.chacha@niafikra.com
 * @email bonifacechacha@gmail.com
 * @date 6/24/16 5:50 PM
 */
public class LoginHeader extends HorizontalLayout {

    private BaseLoginLayout baseLoginLayout;

    public LoginHeader(BaseLoginLayout baseLoginLayout) {
        this.baseLoginLayout = baseLoginLayout;

        build();
    }

    private void build() {
        setWidth("100%");
        addStyleName("backColorWhite");

        putLogo();
        putAuthenticationButtons();

    }

    private void putAuthenticationButtons() {
        // Serve the image from the theme
        HorizontalLayout authenticationLayout = new HorizontalLayout();
        authenticationLayout.setWidth("500px");
        authenticationLayout.setMargin(true);

        addComponent(authenticationLayout);
        setComponentAlignment(authenticationLayout, Alignment.TOP_RIGHT);


        Button logIn = new Button("Sign");
        logIn.setWidth("150px");
        authenticationLayout.addComponent(logIn);
        authenticationLayout.setComponentAlignment(logIn, Alignment.TOP_RIGHT);

        Button signUp = new Button("Create an account");
        signUp.setWidth("200px");
        authenticationLayout.addComponent(signUp);
        authenticationLayout.setComponentAlignment(signUp, Alignment.TOP_RIGHT);

        logIn.addClickListener(e -> {
          baseLoginLayout.getLoginContent().getAuthenticationPanel().showLogin();
        });


        signUp.addClickListener(e -> {
            baseLoginLayout.getLoginContent().getAuthenticationPanel().showRegister();
        });

    }

    private void putLogo() {

        Resource res = new ThemeResource("Logo.png");

        // Display the image without caption
        Image image = new Image(null, res);

        image.setWidth("100px");
        image.setHeight("100px");
        addComponent(image);
        setComponentAlignment(image, Alignment.TOP_LEFT);
    }


}
