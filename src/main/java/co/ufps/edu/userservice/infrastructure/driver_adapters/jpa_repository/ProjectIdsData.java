package co.ufps.edu.userservice.infrastructure.driver_adapters.jpa_repository;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
@Table(name = "projects_ids")
public class ProjectIdsData {
    @Id
    private Long projectsId;

    public ProjectIdsData() {
    }

    public ProjectIdsData(Long projectsId) {
        this.projectsId = projectsId;
    }

    public Long getProjectsId() {
        return projectsId;
    }

    public void setProjectsId(Long projectsId) {
        this.projectsId = projectsId;
    }
}
