package com.loan.entity.User;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Email")
    private String email;

    @Column(name = "Mobile Number")
    private String mobilNumber;

    @Column(name = "City")
    private String city;

    @Column(name = "State")
    private String state;


    private Date dataOfBirth;

    private String password;

    @Transient
    private String otp;


}
