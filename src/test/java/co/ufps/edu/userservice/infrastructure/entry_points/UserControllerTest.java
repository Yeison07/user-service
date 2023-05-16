package co.ufps.edu.userservice.infrastructure.entry_points;

import co.ufps.edu.userservice.domain.model.User;
import co.ufps.edu.userservice.domain.useCase.UserUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.io.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserControllerTest  {

    @InjectMocks
    UserController userController;

    @Mock
    UserUseCase useCase;

    @Test
    public void testAddUser(){
        var request=new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        User user= new User("test@hotmail.com","123","nameTest","lastNameTest");
        ResponseEntity<Object> responseEntity= userController.registerNewUser(user);
        assert(responseEntity.getStatusCode().isSameCodeAs(HttpStatus.CREATED));
    }

    @Test
    public void testFindAll(){
        User user1= new User("test1@hotmail.com","123","nameTest1","lastNameTest1");
        User user2= new User("test2@hotmail.com","231","nameTest2","lastNameTest2");
        User user3= new User("test3@hotmail.com","132","nameTest3","lastNameTest3");

        List<User>users= Arrays.asList(user1,user2,user3);
        when(useCase.findAllUsers()).thenReturn(users);
        var result= userController.getAllUser();
        assertEquals(result.getStatusCode(),HttpStatus.OK);
        assertEquals(result.getBody(),users);

    }

    @Test
    public void testFindUser(){
        User user1= new User("test1@hotmail.com","123","nameTest1","lastNameTest1");
        User user2= new User("test2@hotmail.com","123","nameTest2","lastNameTest2");

        when(useCase.findByEmail("user1")).thenReturn(user1);
        var result= userController.getUserById("user1");
        assertEquals(result.getStatusCode(),HttpStatus.OK);
        assertEquals(result.getBody(),user1);
    }
}