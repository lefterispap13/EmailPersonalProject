package com.papadogiannis.requests;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@Data
@NoArgsConstructor
public class AccountRequest {

    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @NotBlank
    private Date dateOfBirth;
    @NotBlank
    private String gender;
    @NotBlank
    private String password;
    @NotBlank
    private String email;
    @NotBlank
    private String role;

    public AccountRequest(String firstName, String lastName,
                          Date dateOfBirth, String gender,
                          String password, String email, String role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.password = password;
        this.email = email;
        this.role = role;
    }
}
