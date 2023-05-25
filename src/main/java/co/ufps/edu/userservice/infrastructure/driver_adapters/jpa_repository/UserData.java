package co.ufps.edu.userservice.infrastructure.driver_adapters.jpa_repository;


import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user")
public class UserData {

    @Id
    @Column
    private String email;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String lastName;
    @ManyToMany
    @JoinTable(name = "users_projects",
    joinColumns = @JoinColumn(name = "user_id"),inverseJoinColumns = @JoinColumn(name = "project_id_u"))
    private Set<ProjectIdsData> projectIdsData = new HashSet<>();

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

    public Set<ProjectIdsData> getProjectIdsData() {
        return projectIdsData;
    }

    public void setProjectIdsData(Set<ProjectIdsData> projectIdsData) {
        this.projectIdsData = projectIdsData;
    }
}
