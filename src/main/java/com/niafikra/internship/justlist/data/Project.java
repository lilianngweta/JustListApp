package com.niafikra.internship.justlist.data;

/**
 * Created by lilianngweta on 7/11/16.
 */
public class Project {

    private String name;
    private Long id;
    private User user;

    public Project(){
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
