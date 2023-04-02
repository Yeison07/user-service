package co.ufps.edu.userservice.infrastructure.driver_adapters.jpa_repository;


import jakarta.persistence.*;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
public class UserData {

    @Id
    private String email;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String lastName;
    @OneToMany
    @Column(name = "projectId")
    private List<ProjectIdsData> projectIdsData = new ArrayList<>();

    public UserData() {
    }

    public UserData(String email, String password, String name, String lastName) {
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

    public List<ProjectIdsData> getProjectIdsData() {
        return projectIdsData;
    }

}
