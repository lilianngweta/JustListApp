package com.niafikra.internship.justlist.ui.vaadin.login.authentication;

//import java.io.Serializable;

//import com.vaadin.event.ShortcutAction;
//import com.vaadin.server.Page;
//import com.vaadin.shared.ui.label.ContentMode;
//import com.vaadin.ui.Alignment;
import com.niafikra.internship.justlist.data.User;
import com.niafikra.internship.justlist.service.UserService;
import com.vaadin.ui.*;
//import com.vaadin.ui.Label;
//import com.vaadin.ui.Notification;
//import com.vaadin.ui.VerticalLayout;
//import com.vaadin.ui.themes.ValoTheme;
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

        addComponent(email = new TextField("Username"));
        email.setWidth("250px");
        setComponentAlignment(email, Alignment.BOTTOM_CENTER);
        addComponent(password = new PasswordField("Password"));
        password.setWidth("250px");
        setComponentAlignment(password, Alignment.BOTTOM_CENTER);
        //password.setDescription("Write anything");
        CssLayout buttons = new CssLayout();
        // buttons.setStyleName("buttons");
        addComponent(buttons);

        buttons.addComponent(login = new Button("Login"));
        login.setDisableOnClick(true);
        login.addClickListener(this);

    }


    @Override
    public void buttonClick(Button.ClickEvent clickEvent) {

        User user = userService.authenticate(email.getValue(),password.getValue());
        if(user != null){
            Notification.show("Successfully logged in!");
        }
else {
       Notification.show("Either email or password is incorrect, Try Again!");

}
//        email.setNullRepresentation("");
//        password.setNullRepresentation("");
}
}











