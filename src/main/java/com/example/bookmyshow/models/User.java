package com.example.bookmyshow.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User extends BaseModal{
    private String username;
    private String password;
    private String email;

}
