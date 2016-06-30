package com.niafikra.internship.justlist.ui.vaadin.login.authentication;




import com.niafikra.internship.justlist.data.User;
import com.niafikra.internship.justlist.service.UserService;
import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.ui.*;

/**
 * Created by lilianngweta on 6/23/16.
 */
public class RegisterForm extends FormLayout implements Button.ClickListener {

    private Button register;
    private BeanFieldGroup<User> userFieldGroup;
    private User user;

    private UserService userService;
    private Field fullName;
    private Field email;
    private Field password;

    public RegisterForm() {
        user = new User();
        userService = UserService.get();

        userFieldGroup = new BeanFieldGroup<>(User.class);
        userFieldGroup.setItemDataSource(user);
        userFieldGroup.setFieldFactory(new UserFieldFactory());
        build();
    }

    private void build() {
        fullName = userFieldGroup.buildAndBind("Enter your name","fullName");
        addComponent(fullName);
        setComponentAlignment(fullName, Alignment.BOTTOM_CENTER);

        email = userFieldGroup.buildAndBind("email");
        addComponent(email);
        setComponentAlignment(email, Alignment.BOTTOM_CENTER);

        password = userFieldGroup.buildAndBind("password");
        addComponent(password);
        setComponentAlignment(password, Alignment.BOTTOM_CENTER);


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

           // userFieldGroup.setFieldFactory(new UserFieldFactory());
        } catch (FieldGroup.CommitException e) {
            e.printStackTrace();
            //userFieldGroup.setFieldFactory(new UserFieldFactory());
        }

        fullName.setValue("");
        email.setValue("");
        password.setValue("");


    }
}










