package com.cargo.dto;

import com.cargo.model.enums.Role;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AccountDto {

    private long id;

    @NotBlank(message = "First Name is mandatory")
    private String firstName;

    @NotBlank(message = "Last Name is mandatory")
    private String lastName;

    @Column(unique = true)
    @Email(message = "Email is not valid")
    private String email;

    private Role role;

    @Size(message = "Password should contain 8 symbols or more", min = 8)
    private String password;

}
