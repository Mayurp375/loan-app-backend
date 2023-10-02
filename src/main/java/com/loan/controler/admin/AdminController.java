package com.loan.controler.admin;

import com.loan.entity.User.User;
import com.loan.service.admin.AdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    //http://localhost:8080/admin/delete
    @DeleteMapping("delete")
    public ResponseEntity<Map<String, String>> deletApplication(@RequestParam long id){

        adminService.deleteApplication(id);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Deleted successfully");
        return ResponseEntity.status(HttpStatus.OK).body(response);

    }
}
