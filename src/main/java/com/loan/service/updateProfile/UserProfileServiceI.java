package com.loan.service.updateProfile;

import com.loan.entity.User.User;

public interface UserProfileServiceI {
    User saveOrUpdateExtendedProfile(String email, User dto);
}
