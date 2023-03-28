package co.ufps.edu.userservice.domain.model.gateways;

import co.ufps.edu.userservice.domain.model.User;

import java.util.List;

public interface UserGateway {

    User save(User user);
    User deleteById(String email);
    User findById(String email);
    List<User> findAllUser();


}
