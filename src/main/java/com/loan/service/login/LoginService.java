package com.loan.service.login;

import com.loan.entity.User.User;

import java.util.List;

public interface LoginService {
    String validateUser(String email, String password);

    List<User> getAll();
}
