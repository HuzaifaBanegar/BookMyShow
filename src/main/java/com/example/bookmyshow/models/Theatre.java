package com.example.bookmyshow.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Theatre extends BaseModal{
    private String name;
    private String address;
    private List<Screen> screens;
}
