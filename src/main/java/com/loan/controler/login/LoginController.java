package com.loan.controler.login;


import com.loan.entity.User.User;
import com.loan.service.login.LoginServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
@CrossOrigin(origins = "http://localhost:4200")
public class LoginController {

    @Autowired
    private LoginServiceImp userService;

    //http://localhost:8080/v1/login
    @PostMapping("/login")
    public String loginUser(@RequestParam String email, @RequestParam String password) {
        User user = userService.validateUser(email, password);
        if (user != null) {
            return "Login successful for user: " + email;
        } else {
            return "Invalid email or password";
        }
    }



}
