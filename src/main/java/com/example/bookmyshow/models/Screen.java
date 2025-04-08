package com.example.bookmyshow.models;

import com.example.bookmyshow.models.enums.Feature;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Screen extends BaseModal{
    private String title;

    @OneToMany
    private List<Seat> seats;


//    private List<Feature> features;

    @ManyToOne
    private Theatre theatre;
}
