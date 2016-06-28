package com.niafikra.internship.justlist.ui.vaadin.login.authentication;


//import java.io.Serializable;

//import com.vaadin.event.ShortcutAction;
//import com.vaadin.server.Page;
//import com.vaadin.shared.ui.label.ContentMode;
//import com.vaadin.ui.Alignment;

import com.niafikra.internship.justlist.data.User;
import com.niafikra.internship.justlist.service.UserService;
import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Notification;

//import com.vaadin.ui.Label;
//import com.vaadin.ui.Notification;
//import com.vaadin.ui.VerticalLayout;
//import com.vaadin.ui.themes.ValoTheme;


/**
 * Created by lilianngweta on 6/23/16.
 */
public class RegisterForm extends FormLayout implements Button.ClickListener {

    private Button register;
    private BeanFieldGroup<User> userFieldGroup;
    private User user;

    private UserService userService;

    public RegisterForm() {
        user = new User();
        userService = UserService.get();

        userFieldGroup = new BeanFieldGroup<>(User.class);
        userFieldGroup.setItemDataSource(user);

        build();
    }

    private void build() {
        addComponent(userFieldGroup.buildAndBind("fullName"));
        addComponent(userFieldGroup.buildAndBind("email"));
        addComponent(userFieldGroup.buildAndBind("password"));

        HorizontalLayout buttons = new HorizontalLayout();
        addComponent(buttons);

        buttons.addComponent(register = new Button("Register"));
        register.setDisableOnClick(true);

        register.addClickListener(this);
    }

    @Override
    public void buttonClick(Button.ClickEvent event) {
        try {
            userFieldGroup.commit();
            boolean result = userService.register(user);

            if(result) Notification.show("Successfully registered user");
        } catch (FieldGroup.CommitException e) {
            e.printStackTrace();
        }

    }
}










