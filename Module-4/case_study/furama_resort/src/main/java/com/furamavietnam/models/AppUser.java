package com.furamavietnam.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "user")
@NoArgsConstructor
@Getter
@Setter
public class AppUser {

    @Id
    private String username;

    @Column(name = "encrypted_password", nullable = false)
    private String encryptedPassword;

    @Column(name = "enabled", nullable = false)
    private boolean enabled;

    @OneToOne(mappedBy = "appUser")
    @JsonIgnore
    private Employee employee;

    @OneToMany(mappedBy = "appUser", cascade = CascadeType.REMOVE)
    @JsonIgnore
    private Set<UserRole> userRoles;

}
