package com.niafikra.internship.justlist.ui.vaadin.login.authentication;

//import java.io.Serializable;

//import com.vaadin.event.ShortcutAction;
//import com.vaadin.server.Page;
//import com.vaadin.shared.ui.label.ContentMode;
//import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.FormLayout;
//import com.vaadin.ui.Label;
//import com.vaadin.ui.Notification;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
//import com.vaadin.ui.VerticalLayout;
//import com.vaadin.ui.themes.ValoTheme;
import com.vaadin.ui.LoginForm.LoginListener;

/**
 * Created by lilianngweta on 6/23/16.
 */
public class LogInForm extends FormLayout {


    /**
     * UI content when the user is not logged in yet.
     */


    public TextField username;
    public PasswordField password;
    public Button login;
    public Button forgotPassword;

    public LogInForm() {
        build();
    }

    public void build() {
        setSizeFull();
        setMargin(true);

        addComponent(username = new TextField("Username"));
        username.setWidth("400px");
        addComponent(password = new PasswordField("Password"));
        password.setWidth("400px");
        //password.setDescription("Write anything");
        CssLayout buttons = new CssLayout();
        // buttons.setStyleName("buttons");
        addComponent(buttons);

        buttons.addComponent(login = new Button("Login"));
        login.setDisableOnClick(true);

    }



}











