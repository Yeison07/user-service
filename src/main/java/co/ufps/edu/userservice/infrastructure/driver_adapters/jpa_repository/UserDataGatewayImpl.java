package co.ufps.edu.userservice.infrastructure.driver_adapters.jpa_repository;

import co.ufps.edu.userservice.domain.model.User;
import co.ufps.edu.userservice.domain.model.gateways.UserGateway;
import co.ufps.edu.userservice.infrastructure.feign_client.ProjectFeignClient;
import co.ufps.edu.userservice.infrastructure.mapper.MapperUser;
import org.springframework.orm.jpa.JpaObjectRetrievalFailureException;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDataGatewayImpl implements UserGateway {

    private final MapperUser mapperUser;
    private final UserDataJpaRepository repository;
    private final ProjectFeignClient projectFeignClient;


    public UserDataGatewayImpl(MapperUser mapperUser, UserDataJpaRepository repository, ProjectFeignClient projectFeignClient) {
        this.mapperUser = mapperUser;
        this.repository = repository;
        this.projectFeignClient = projectFeignClient;
    }

    @Override
    public User save(User user) {
        if (user==null){
            return null;
        }
        UserData userData= mapperUser.toUserData(user);
        return mapperUser.toUser(repository.save(userData));
    }

    @Override
    public void deleteById(String email) {
        repository.deleteById(email);
    }

    @Override
    public User findById(String email) {
        var user=mapperUser.toUser(repository.findById(email).orElse(null));
        return user;
    }

    @Override
    public List<User> findAllUser() {
        return mapperUser.toListUser(repository.findAll());
    }

    @Override
    public List<Object> findAllProjectsByUser(String id) {
        return repository.projectsByUser(id);
    }

    @Override
    public User assignProject(User user, Long idProject) {
        if (idProject==null || user.getEmail()==null || user.getEmail().isEmpty()){
            return null;
        }
        ProjectIdsData project=new ProjectIdsData();
        project.setProjectsId(idProject);
        UserData userData= mapperUser.toUserData(user);
        userData.getProjectIdsData().add(project);
        try {
        return mapperUser.toUser(repository.save(userData));
        }
        catch (JpaObjectRetrievalFailureException e){
            System.err.println(e);
            return null;
        }

    }

    @Override
    public List<Object> findAllProjectsDataById(List<Long> projectsId) {
        return projectFeignClient.getProjectByUserId(projectsId);
    }
}
