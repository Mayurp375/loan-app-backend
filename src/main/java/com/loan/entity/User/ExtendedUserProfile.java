package com.loan.entity.User;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "extended_user_profile")
public class ExtendedUserProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // One-to-one mapping with the User entity
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "bank_account_number")
    private String bankAccountNumber;

    @Column(name = "bank_statement_file")
    private String bankStatementFile; // This can be a file path or Blob based on your storage strategy

    @Column(name = "aadhaar_card_number")
    private String aadhaarCardNumber;

    @Column(name = "aadhaar_card_file")
    private String aadhaarCardFile;

    @Column(name = "cibil_score")
    private Integer cibilScore;

    // getters, setters, etc.
}
