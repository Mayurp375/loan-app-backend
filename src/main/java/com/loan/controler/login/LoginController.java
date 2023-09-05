package com.loan.controler.login;


import com.loan.entity.User.LoginDTO;
import com.loan.service.login.LoginServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
@CrossOrigin(origins = "http://localhost:4200")
public class LoginController {

    @Autowired
    private LoginServiceImp userService;

    //http://localhost:8080/v1/login

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody LoginDTO loginDTO) {
        String token = userService.validateUser(loginDTO.getEmail(), loginDTO.getPassword());

        if (token != null) {
            return ResponseEntity.status(HttpStatus.OK).header("Authorization",token).body("login success");
//            return ResponseEntity.status(HttpStatus.OK).body("user login success");
//                    "Login successful for user: " + loginDTO.getEmail();
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid email or password");
        }
    }
}
