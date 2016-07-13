package com.niafikra.internship.justlist.ui.vaadin.login.authentication;

import com.niafikra.internship.justlist.JustListAppUI;
import com.niafikra.internship.justlist.data.User;
import com.niafikra.internship.justlist.service.UserService;
import com.vaadin.ui.*;
import com.vaadin.ui.Button.ClickListener;


/**
 * Created by lilianngweta on 6/23/16.
 */
public class LogInForm extends FormLayout implements ClickListener {


    /**
     * UI content when the user is not logged in yet.
     */


    private UserService userService;
    private TextField email;
    private PasswordField password;
    private Button login;


    public LogInForm() {
        build();
        userService = UserService.get();

    }

    public void build() {
        setSizeFull();
        setMargin(true);

        addComponent(email = new TextField("Email"));
        email.setWidth("250px");
        setComponentAlignment(email, Alignment.BOTTOM_CENTER);
        addComponent(password = new PasswordField("Password"));
        password.setWidth("250px");
        setComponentAlignment(password, Alignment.BOTTOM_CENTER);
        CssLayout buttons = new CssLayout();
        addComponent(buttons);

        buttons.addComponent(login = new Button("Login"));
        login.setDisableOnClick(false);
        login.addClickListener(this);

    }



    @Override
    public void buttonClick(Button.ClickEvent clickEvent) {

        User user = userService.authenticate(email.getValue(), password.getValue());
        if (user != null) {

            JustListAppUI justListAppUI = (JustListAppUI) getUI();
            justListAppUI.getNavigator().navigateTo("main");
            //Notification.show("Successfully logged in!");
        } else {
            Notification.show("Either email or password is incorrect, Try Again!");

        }
        email.setValue("");
        password.setValue("");

    }
}











