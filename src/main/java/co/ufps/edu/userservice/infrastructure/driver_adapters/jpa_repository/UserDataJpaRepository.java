package co.ufps.edu.userservice.infrastructure.driver_adapters.jpa_repository;

import co.ufps.edu.userservice.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDataJpaRepository extends JpaRepository <UserData, String>{
}
