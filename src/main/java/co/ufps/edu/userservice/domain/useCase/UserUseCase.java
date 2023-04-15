package co.ufps.edu.userservice.domain.useCase;

import co.ufps.edu.userservice.domain.model.User;
import co.ufps.edu.userservice.domain.model.gateways.UserGateway;

import java.util.List;

public class UserUseCase {

    private final UserGateway gateway;

    public UserUseCase(UserGateway gateway) {
        this.gateway = gateway;
    }

    public User saveUser(User user) {
        return gateway.save(user);
    }

    public void deleteUserByEmail(String email) {
        gateway.deleteById(email);
    }

    public User findByEmail(String email) {
        return gateway.findById(email);
    }

    public List<User> findAllUsers(){
        return gateway.findAllUser();
    }

    public List<Object> findAllProjectsByUserId(String id){
        return gateway.findAllProjectsByUser(id);
    }

    public User assignProjectToUser(User user,Long idProject){
         return gateway.assignProject(user,idProject);
    }

    public List<Object> getProjectsDataById(List<Long> projectsId){
        return gateway.findAllProjectsDataById(projectsId);
    }
}
