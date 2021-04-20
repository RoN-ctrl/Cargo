package com.cargo.model;

import com.cargo.model.enums.Role;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull(message = "Role is mandatory")
    private Role role = Role.ROLE_USER;

    @NotBlank(message = "First Name is mandatory")
    private String firstName;

    @NotBlank(message = "Last Name is mandatory")
    private String lastName;

    @Column(unique = true)
    @NotBlank(message = "Email is mandatory")
    @Email(message = "Email is not valid")
    private String email;

    @Size(message = "Password should contain 8 symbols or more", min = 8)
    private String password;

    @ToString.Exclude
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "account")
    private List<Parcel> parcelsAccount;

}
