package co.ufps.edu.userservice.infrastructure.driver_adapters.jpa_repository;

import co.ufps.edu.userservice.domain.model.User;
import co.ufps.edu.userservice.domain.model.gateways.UserGateway;
import co.ufps.edu.userservice.infrastructure.mapper.MapperUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
public class UserDataGatewayImpl implements UserGateway {

    private final MapperUser mapperUser;
    private final UserDataJpaRepository repository;


    public UserDataGatewayImpl(MapperUser mapperUser, UserDataJpaRepository repository) {
        this.mapperUser = mapperUser;
        this.repository = repository;
    }

    @Override
    public User save(User user) {
        if (user==null){

        }
        UserData userData= mapperUser.toUserData(user);
        return mapperUser.toUser(repository.save(userData));
    }

    @Override
    public User deleteById(String email) {
        return null;
    }

    @Override
    public User findById(String email) {
        return null;
    }

    @Override
    public List<User> findAllUser() {
        return mapperUser.toListUser(repository.findAll());
    }
}
