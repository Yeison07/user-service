package co.ufps.edu.userservice.infrastructure.entry_points;

import co.ufps.edu.userservice.domain.model.User;
import co.ufps.edu.userservice.domain.useCase.UserUseCase;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserUseCase useCase;

    public UserController(UserUseCase useCase) {
        this.useCase = useCase;
    }


    @RequestMapping(path = "/getAllUsers",method = RequestMethod.GET)
    public List<User> getAllUser(){
        return useCase.findAllUsers();
    }

}
