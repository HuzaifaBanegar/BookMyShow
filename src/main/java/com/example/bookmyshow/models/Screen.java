package com.example.bookmyshow.models;

import com.example.bookmyshow.models.enums.Feature;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name="screens")
public class Screen extends BaseModal{
    private String title;

    @OneToMany
    @JoinColumn(name="screen_id")
    private List<Seat> seats;

    @Enumerated(EnumType.ORDINAL)
    @ElementCollection
    private List<Feature> features;

    @ManyToOne
    private Theatre theatre;
}
