package com.loan.controler.login;


import com.loan.entity.User.LoginDTO;
import com.loan.entity.User.User;
import com.loan.service.login.LoginServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
@CrossOrigin(origins = "http://localhost:4200")
public class LoginController {

    @Autowired
    private LoginServiceImp userService;

    //http://localhost:8080/v1/login

    @PostMapping("/login")
    public ResponseEntity<LoginDTO> loginUser(@RequestBody LoginDTO loginDTO) {
        String token = userService.validateUser(loginDTO.getEmail(), loginDTO.getPassword());

        if (token != null) {
            return ResponseEntity.status(HttpStatus.OK).header("Authorization",token).body(loginDTO);
//            return ResponseEntity.status(HttpStatus.OK).body("user login success");
//                    "Login successful for user: " + loginDTO.getEmail();
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(loginDTO);
        }
    }

    //http://localhost:8080/v1/applications
    /*Admin*/
    @GetMapping("/applications")
    public ResponseEntity<List<User>> getAllApplicants(){
      return ResponseEntity.ok(userService.getAll());
    }
}
