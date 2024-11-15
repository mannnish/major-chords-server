package com.todd.majorChordsServer.contollers;

import com.todd.majorChordsServer.dtos.UserSignUpDTO;
import com.todd.majorChordsServer.dtos.UserTokenDTO;
import com.todd.majorChordsServer.services.AuthService;
import com.todd.majorChordsServer.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(path = "/auth")
public class AuthController {

    @Autowired private UserService userService;
    @Autowired private AuthService authService;

    @PostMapping(path = "/signup")
    ResponseEntity<Map<String, Object>> signup(@RequestBody @Valid UserSignUpDTO userSignUpDTO) throws Exception {
        authService.signUpUser(userSignUpDTO);
        Map<String, Object> map = new HashMap<>();
        map.put("message", "success");
        return new ResponseEntity<>(map, HttpStatus.CREATED);
    }

    @PostMapping(path = "/login")
    ResponseEntity<UserTokenDTO> login(@RequestBody UserSignUpDTO loginDTO){
        return new ResponseEntity<>(authService.login(loginDTO), HttpStatus.OK);
    }
}
