package com.loan.entity.User;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String email;

    private String mobilNumber;

    private String city;

    private String state;

    private Date dataOfBirth;

    private String password;

    public User(String name, String email, String mobilNumber, String city, String state, Date dataOfBirth, String password) {
        this.name = name;
        this.email = email;
        this.mobilNumber = mobilNumber;
        this.city = city;
        this.state = state;
        this.dataOfBirth = dataOfBirth;
        this.password = password;
    }
}
