package com.niafikra.internship.justlist.data;

/**
 * Created by lilianngweta on 7/14/16.
 */

public class Task {

    private Long id;
    private String name;
    private Project project;
    private boolean completed;

    public Task() {

    }

    public Task(Long id, String name, Project project, Boolean completed) {

        this.id = id;
        this.name = name;
        this.project = project;
    }

    public User getUser() {
        if (project == null) return null;
        return project.getUser();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Task task = (Task) o;

        if (id != null ? !id.equals(task.id) : task.id != null) return false;
        return !(name != null ? !name.equals(task.name) : task.name != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
