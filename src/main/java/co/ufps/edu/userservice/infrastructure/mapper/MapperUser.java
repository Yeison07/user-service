package co.ufps.edu.userservice.infrastructure.mapper;

import co.ufps.edu.userservice.domain.model.User;
import co.ufps.edu.userservice.infrastructure.driver_adapters.jpa_repository.UserData;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MapperUser {

    User toUser(UserData userData);
    UserData toUserData(User user);
    List<User> toListUser(List<UserData>userDataList);
    List<UserData> toListUserData(List<User>userList);

}
