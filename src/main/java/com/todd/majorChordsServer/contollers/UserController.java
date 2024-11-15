package com.todd.majorChordsServer.contollers;

import com.todd.majorChordsServer.dtos.UserOutputDTO;
import com.todd.majorChordsServer.dtos.UserSignUpDTO;
import com.todd.majorChordsServer.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/user")
public class UserController {

    @Autowired private UserService userService;

    @GetMapping(path = "/me")
    public ResponseEntity<UserOutputDTO> getMe() throws ClassNotFoundException {
        UserOutputDTO user = userService.getMe();
        if(user == null)
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

}
