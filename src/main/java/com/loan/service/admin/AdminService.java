package com.loan.service.admin;

import com.loan.entity.User.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AdminService {
    List<User> getAll();

    void deleteApplication(long id);
}
