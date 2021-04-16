package com.cargo.dto;

import com.cargo.model.enums.Role;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AccountDto {

    private long id;
    private Role role;
    private String firstName;
    private String lastName;
    private String email;
    private String password;

}
