package co.ufps.edu.userservice.infrastructure.driver_adapters.jpa_repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserDataJpaRepository extends JpaRepository <UserData, String>{

    @Query(value = "SELECT p.project_id_u " +
            "FROM users_projects p where p.user_id=:email",nativeQuery = true)
    List<Object> projectsByUser(@Param("email") String email);


}
