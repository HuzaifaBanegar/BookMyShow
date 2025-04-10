package com.example.bookmyshow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name="theatres")
public class Theatre extends BaseModal{
    private String name;
    private String address;

    @OneToMany
    @JoinColumn(name="theatre_id")
    private List<Screen> screens;
}
