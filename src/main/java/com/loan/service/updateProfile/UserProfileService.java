//package com.loan.service.updateProfile;
//
//import com.loan.entity.User.User;
//import com.loan.entity.User.dto.ExtendedUserProfileDTO;
//import com.loan.repository.update.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class UserProfileService {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Autowired
////    private ExtendedUserProfileRepository extendedUserProfileRepository;
//
//    public void saveOrUpdateExtendedProfile(String email, ExtendedUserProfileDTO dto) {
//        User user = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("User not found"));
//
//        // If extended profile already exists, throw an exception or simply return
//        if (user.getExtendedProfile() != null) {
//            throw new RuntimeException("Extended profile already exists for the user");
//        }
//
////        ExtendedUserProfile profile = new ExtendedUserProfile();
////        profile.setBankAccountNumber(dto.getBankAccountNumber());
////        // Save the files and set the paths, or store the files as Blobs
////        profile.setAadhaarCardNumber(dto.getAadhaarCardNumber());
////        profile.setCibilScore(dto.getCibilScore());
////
////        user.setExtendedProfile(profile);
////        profile.setUser(user);
////
////        extendedUserProfileRepository.save(profile);
//    }
//}
