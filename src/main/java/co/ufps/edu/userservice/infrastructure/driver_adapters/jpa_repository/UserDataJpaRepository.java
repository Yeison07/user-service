package co.ufps.edu.userservice.infrastructure.driver_adapters.jpa_repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserDataJpaRepository extends JpaRepository <UserData, String>{

    @Query(value = "SELECT p.project_ids_data_projects_id " +
            "FROM user_project_ids_data p where :email=p.user_data_email",nativeQuery = true)
    List<Object> projectsByUser(@Param("email") String email);


}
