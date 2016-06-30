package com.niafikra.internship.justlist.ui.vaadin.login.authentication;

import com.vaadin.data.Item;
import com.vaadin.data.fieldgroup.DefaultFieldGroupFieldFactory;
import com.vaadin.ui.Component;
import com.vaadin.ui.DefaultFieldFactory;
import com.vaadin.ui.Field;
import com.vaadin.ui.TextField;

/**
 * Created by lilianngweta on 6/28/16.
 */
public class UserFieldFactory extends DefaultFieldGroupFieldFactory {

    @Override
    public <T extends Field> T createField(Class<?> type, Class<T> fieldType) {
        TextField field = (TextField)  super.createField(type, fieldType);

        field.setNullRepresentation("");

        field.setValue("");

        return (T) field;
    }





}
