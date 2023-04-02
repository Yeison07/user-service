package co.ufps.edu.userservice.infrastructure.entry_points;

import co.ufps.edu.userservice.domain.model.User;
import co.ufps.edu.userservice.domain.useCase.UserUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserUseCase useCase;

    public UserController(UserUseCase useCase) {
        this.useCase = useCase;
    }

    @RequestMapping(path = "/registerNewUser",method = RequestMethod.POST)
    public ResponseEntity<Object> registerNewUser(@RequestBody User user){
        return new ResponseEntity<>(useCase.saveUser(user), HttpStatus.CREATED);
    }

    @RequestMapping(path = "/getAllUsers",method = RequestMethod.GET)
    public ResponseEntity<Object> getAllUser(){
        return new ResponseEntity<>(useCase.findAllUsers(), HttpStatus.OK);
    }

    @RequestMapping(path = "/getUserById",method = RequestMethod.GET)
    public ResponseEntity<Object> getUserById(@RequestParam String email){
        var user=useCase.findByEmail(email);
        System.out.println(user);
        if (user==null){
            String body="Theres not register with that email";
            return new ResponseEntity<>(body,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @RequestMapping(path = "/getProjectByUserId",method = RequestMethod.GET)
    public ResponseEntity<Object> getProjectByUserId(@RequestParam String email){
        var projects=useCase.findAllProjectsByUserId(email);
        if (projects==null || projects.isEmpty()){
            String body="Theres not projects register with that email";
            return new ResponseEntity<>(body,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(projects, HttpStatus.OK);
    }

    @RequestMapping(path = "/assignProjectToUser",method = RequestMethod.POST)
    public ResponseEntity<Object> assignProjectToUser(@RequestParam Long id,@RequestBody User user){
        var userResponse=useCase.assignProjectToUser(user,id);
        if (userResponse==null){
            String body="Its mandatory to send the id of the project and the user email, make sure that the project id you send exits";
            return new ResponseEntity<>(body,HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(userResponse, HttpStatus.OK);
    }

}
