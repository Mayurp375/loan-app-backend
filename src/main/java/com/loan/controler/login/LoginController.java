package com.loan.controler.login;


import com.loan.entity.User.LoginDTO;
import com.loan.service.login.LoginServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/v1")
@CrossOrigin(origins = "http://localhost:4200")
public class LoginController {

    @Autowired
    private LoginServiceImp userService;

    //http://localhost:8080/v1/login

    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> loginUser(@RequestBody LoginDTO loginDTO) {
        String token = userService.validateUser(loginDTO.getEmail(), loginDTO.getPassword());

//        return ResponseEntity.status(HttpStatus.OK).header("Authorization",token).body(loginDTO);


        Map<String, Object> responseBody = new HashMap<>();

        if (token != null) {
            responseBody.put("status", "success");
            responseBody.put("message", "User login successful");
            responseBody.put("email", loginDTO.getEmail());
            return ResponseEntity.status(HttpStatus.OK).header("Authorization", token).body(responseBody);
        } else {
            responseBody.put("status", "error");
            responseBody.put("message", "Invalid email or password");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseBody);
        }
    }

}
