package com.example.bookmyshow.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="users")
public class User extends BaseModal{
    private String username;
    private String password;
    private String email;

}
