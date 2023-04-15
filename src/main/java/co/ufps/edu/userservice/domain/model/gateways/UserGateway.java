package co.ufps.edu.userservice.domain.model.gateways;

import co.ufps.edu.userservice.domain.model.User;

import java.util.List;

public interface UserGateway {

    User save(User user);
    void deleteById(String email);
    User findById(String email);
    List<User> findAllUser();
    List<Object>findAllProjectsByUser(String id);
    User assignProject(User user,Long idProject);
    List<Object> findAllProjectsDataById(List<Long>projectsId);


}
