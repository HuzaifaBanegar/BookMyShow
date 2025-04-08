package com.example.bookmyshow.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Movie extends BaseModal{
    private String movieName;
    private double rating;
}
