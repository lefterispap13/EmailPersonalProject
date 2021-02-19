package com.papadogiannis.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;


@Entity
@Table(name="accounts")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    private Long accountID;

    @Column(name="first_name", nullable = false)
    private String firstName;

    @Column(name="last_name",nullable = false)
    private String lastName;

    @Column(name="date_of_birth")
    private Date dateOfBirth;

    @Column(name="gender")
    private String gender;

    @Column(name="password",nullable = false,unique = true)
    private String password;

    @Column(name="email",nullable = false,unique = true)
    private String email;

    @ManyToOne
    @JoinColumn(name="role_id")
    private Role role;

    @ManyToMany
    @JoinTable(
            joinColumns = @JoinColumn(name="account_id"),
            inverseJoinColumns = @JoinColumn(name="email_id"))
    private Set<Email> emails;

    public Account(String firstName, String lastName,
                   Date dateOfBirth, String gender,
                   String password, String email, Role role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.password = password;
        this.email = email;
        this.role = role;
    }

    public Account(String firstName, String lastName,
                   Date dateOfBirth, String gender,
                   String password, String email, Role role, Set<Email> emails) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.password = password;
        this.email = email;
        this.role = role;
        this.emails = emails;
    }
}
