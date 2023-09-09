package com.loan.service.updateProfile;

import com.loan.entity.User.ExtendedUserProfile;
import com.loan.entity.User.User;
import com.loan.repository.register.RegistrationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserProfileService implements UserProfileServiceI {

    @Autowired
    private RegistrationRepo userRepository;

    public User saveOrUpdateExtendedProfile(String email, User dto) {
        User existingUser = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("User not found"));

        // Check if an extended profile already exists for this user
        ExtendedUserProfile extendedProfile = existingUser.getExtendedProfile();

        // If not, create a new ExtendedUserProfile for this user
        if (extendedProfile == null) {
            extendedProfile = new ExtendedUserProfile();
            existingUser.setExtendedProfile(extendedProfile);
        }

        extendedProfile.setBankAccountNumber(dto.getExtendedProfile().getBankAccountNumber());
        extendedProfile.setAadhaarCardNumber(dto.getExtendedProfile().getAadhaarCardNumber());
        extendedProfile.setCibilScore(dto.getExtendedProfile().getCibilScore());
        return userRepository.save(existingUser);

    }
}
