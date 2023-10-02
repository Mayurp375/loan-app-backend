package com.loan.service.admin;

import com.loan.entity.User.User;
import com.loan.repository.register.RegistrationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    RegistrationRepo registrationRepo;
    @Override
    public List<User> getAll() {
        return registrationRepo.findAll();
    }

    @Override
    public void deleteApplication(long id) {
        User user = registrationRepo.findById(id).orElseThrow();
        registrationRepo.delete(user);
    }
}
