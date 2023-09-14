package com.loan.controler.admin;

import com.loan.entity.User.User;
import com.loan.service.admin.AdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*Admin*/
@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "http://localhost:4200")
public class AdminController {

    @Autowired
    private AdminServiceImpl adminService;

    //http://localhost:8080/admin/applications

    @GetMapping("/applications")
    public ResponseEntity<List<User>> getAllApplicants(){
        return ResponseEntity.ok(adminService.getAll());
    }

    @DeleteMapping
    public ResponseEntity<String> deletApplication(@RequestParam String email){

        adminService.deleteApplication(email);
        return ResponseEntity.status(HttpStatus.OK).body("Your application is rejected.");
    }
}
