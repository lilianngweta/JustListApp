package com.niafikra.internship.justlist.ui.vaadin.login;

import com.vaadin.server.Resource;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.*;

/**
 * @author Boniface Chacha
 * @email boniface.chacha@niafikra.com
 * @email bonifacechacha@gmail.com
 * @date 6/24/16 5:48 PM
 */
public class BaseLoginLayout extends VerticalLayout{

    private LoginHeader loginHeader;
    private LoginContent loginContent;

    public BaseLoginLayout() {
        loginHeader = new LoginHeader(this);
        loginContent =new LoginContent(this);

        build();
    }

    private void build() {
        setSizeFull();

        addComponent(loginHeader);
        addComponent(loginContent);

        setExpandRatio(loginContent,1);

    }

    public LoginHeader getLoginHeader() {
        return loginHeader;
    }

    public LoginContent getLoginContent() {
        return loginContent;
    }
}
