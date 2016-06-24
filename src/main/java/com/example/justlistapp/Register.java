package com.example.justlistapp;


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
public class Register extends CssLayout {


        public TextField username;
        public TextField email;
        public PasswordField password;
        public Button register;




        public Component buildRegisterForm() {

            FormLayout registerForm = new FormLayout();

            registerForm.setSizeUndefined();
            registerForm.setMargin(true);

            registerForm.addComponent(username = new TextField("Username"));
            username.setWidth("400px");
            registerForm.addComponent(email = new TextField("Email"));
            email.setWidth("400px");
            registerForm.addComponent(password = new PasswordField("Password"));
            password.setWidth("400px");
            //password.setDescription("Write anything");
            CssLayout buttons = new CssLayout();
            // buttons.setStyleName("buttons");
            registerForm.addComponent(buttons);

            buttons.addComponent(register = new Button("Register"));
            register.setDisableOnClick(true);

            //forgotPassword.addStyleName(ValoTheme.BUTTON_LINK);
            return registerForm;
        }








    }










