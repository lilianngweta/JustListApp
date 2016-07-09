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

    private LoginView loginView;

    private Logo logo;
    private LoginCreateAccount loginCreateAccount;

    public LoginHeader(LoginView loginView) {
        this.loginView = loginView;
        logo = new Logo();
        loginCreateAccount = new LoginCreateAccount(loginView);

        addComponent(logo);
        logo.addComponent(loginCreateAccount);


    }






}
