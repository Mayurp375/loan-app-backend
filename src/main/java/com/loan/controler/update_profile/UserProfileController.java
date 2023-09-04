//package com.loan.controler.update_profile;
//
//import com.loan.entity.User.dto.ExtendedUserProfileDTO;
//import com.loan.service.updateProfile.UserProfileService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/api/user")
//@CrossOrigin(origins = "http://localhost:4200")
//public class UserProfileController {
//
//    @Autowired
//    private UserProfileService userProfileService;
//
//    @PostMapping("/profile/{email}")
//    public ResponseEntity<Void> saveOrUpdateExtendedProfile(@PathVariable String email, @RequestBody ExtendedUserProfileDTO dto) {
//        userProfileService.saveOrUpdateExtendedProfile(email, dto);
//        return ResponseEntity.ok().build();
//    }
//}
