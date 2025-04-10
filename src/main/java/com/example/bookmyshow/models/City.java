package com.example.bookmyshow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity(name="cities")
public class City extends BaseModal{
    private String name;

    @OneToMany
    @JoinColumn(name="city_id")
    private List<Theatre> theatres;
}
