package com.cargo.model;

import com.cargo.model.enums.Role;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private Role role = Role.ROLE_USER;

    private String firstName;

    private String lastName;

    @Column(unique = true)
    private String email;

    @ToString.Exclude
    private String password;

    @ToString.Exclude
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "account")
    private List<Parcel> parcelsAccount;

}
