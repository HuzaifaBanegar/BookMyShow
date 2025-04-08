package com.example.bookmyshow.models;

import com.example.bookmyshow.models.enums.Feature;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Screen extends BaseModal{
    private String title;
    private List<Seat> seats;
    private List<Feature> features;
    private Theatre theatre;
}
