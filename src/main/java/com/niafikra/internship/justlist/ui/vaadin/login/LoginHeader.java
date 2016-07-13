package com.niafikra.internship.justlist.ui.vaadin.login;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.HorizontalLayout;

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
        setWidth("100%");

        addStyleName("backColorWhite");
        this.loginView = loginView;
        logo = new Logo();
        loginCreateAccount = new LoginCreateAccount(loginView);

        addComponent(logo);
        addComponent(loginCreateAccount);
        setComponentAlignment(loginCreateAccount, Alignment.MIDDLE_RIGHT);
    }


}
