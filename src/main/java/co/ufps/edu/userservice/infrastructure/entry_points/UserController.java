package co.ufps.edu.userservice.infrastructure.entry_points;

import co.ufps.edu.userservice.domain.model.User;
import co.ufps.edu.userservice.domain.useCase.UserUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@CrossOrigin
public class UserController {

    private final UserUseCase useCase;

    public UserController(UserUseCase useCase) {
        this.useCase = useCase;
    }

    @RequestMapping(path = "/registerNewUser", method = RequestMethod.POST)
    public ResponseEntity<Object> registerNewUser(@RequestBody User user) {
        return new ResponseEntity<>(useCase.saveUser(user), HttpStatus.CREATED);
    }

    @RequestMapping(path = "/getAllUsers", method = RequestMethod.GET)
    public ResponseEntity<Object> getAllUser() {
        return new ResponseEntity<>(useCase.findAllUsers(), HttpStatus.OK);
    }

    @RequestMapping(path = "/getUserById", method = RequestMethod.GET)
    public ResponseEntity<Object> getUserById(@RequestParam String email) {
        var user = useCase.findByEmail(email);
        System.out.println(user);
        if (user == null) {
            String body = "Theres not register with that email";
            return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }


    @RequestMapping(path = "/getProjectByUserId", method = RequestMethod.POST)
    public ResponseEntity<Object> getProjectByUserId(@RequestBody User user) {
        var projects = useCase.findAllProjectsByUserId(user.getEmail());
        if (projects == null || projects.isEmpty()) {
            String body = "Theres not projects register with that email";
            return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(projects, HttpStatus.OK);
    }

    @RequestMapping(path = "/assignProjectToUser", method = RequestMethod.POST)
    public ResponseEntity<Object> assignProjectToUser(@RequestParam Long id, @RequestBody User user) {
        var userResponse = useCase.assignProjectToUser(user, id);
        if (userResponse == null) {
            String body = "There was an error trying to assign this project, " +
                    "this may be mainly due to the fact that you are trying to assign it to a project or user that does not exist," +
                    " contact your system administrator and point out this error.";
            return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(userResponse, HttpStatus.OK);
    }

    @RequestMapping(path = "/getAllProjectsDataById", method = RequestMethod.POST)
    public ResponseEntity<Object> findAllProjectsById(@RequestBody List<Long> projectsId) {
        var projects = useCase.getProjectsDataById(projectsId);
        if (projects == null) {
            String message = "The requested resource was not found";
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(projects, HttpStatus.OK);
    }

}
