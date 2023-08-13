package com.loan.service.login;

import com.loan.entity.User.User;

public interface LoginService {
    public User validateUser(String email, String password);
}
