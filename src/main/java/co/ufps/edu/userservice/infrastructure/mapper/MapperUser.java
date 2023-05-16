package co.ufps.edu.userservice.infrastructure.mapper;

import co.ufps.edu.userservice.domain.model.User;
import co.ufps.edu.userservice.infrastructure.driver_adapters.jpa_repository.UserData;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper(componentModel = "spring")
public interface MapperUser {
    User toUser(UserData userData);
    UserData toUserData(User user);
    List<User> toListUser(List<UserData>userDataList);
    List<UserData> toListUserData(List<User>userList);


}
