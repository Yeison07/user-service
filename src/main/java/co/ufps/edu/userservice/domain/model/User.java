package co.ufps.edu.userservice.domain.model;

import java.util.List;

public class User {

    private String email;
    private String password;
    private String name;
    private String lastName;
    private List<Long>projectsList;

    public User() {
    }

    public User(String email, String password, String name, String lastName) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Long> getProjectsList() {
        return projectsList;
    }

    public void setProjectsList(List<Long> projectsList) {
        this.projectsList = projectsList;
    }
}
