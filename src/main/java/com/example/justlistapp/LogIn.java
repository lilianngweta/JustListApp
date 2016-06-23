package com.example.justlistapp;

import java.io.Serializable;

import com.vaadin.event.ShortcutAction;
import com.vaadin.server.Page;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;
import sun.jvm.hotspot.debugger.cdbg.AccessControl;
import com.vaadin.ui.LoginForm.LoginListener;

/**
 * Created by lilianngweta on 6/23/16.
 */
public class LogIn extends CssLayout {










    /**
     * UI content when the user is not logged in yet.
     */


        public TextField username;
        public PasswordField password;
        public Button login;
        public Button forgotPassword;
        public LoginListener loginListener;
        public AccessControl accessControl;




        public Component buildLoginForm() {
            FormLayout loginForm = new FormLayout();

            loginForm.addStyleName("login-form");
            loginForm.setSizeUndefined();
            loginForm.setMargin(false);

            loginForm.addComponent(username = new TextField("Username", "admin"));
            username.setWidth(15, Unit.EM);
            loginForm.addComponent(password = new PasswordField("Password"));
            password.setWidth(15, Unit.EM);
            password.setDescription("Write anything");
            CssLayout buttons = new CssLayout();
            buttons.setStyleName("buttons");
            loginForm.addComponent(buttons);

            buttons.addComponent(login = new Button("Login"));
            login.setDisableOnClick(true);

            forgotPassword.addStyleName(ValoTheme.BUTTON_LINK);
            return loginForm;
        }








}











