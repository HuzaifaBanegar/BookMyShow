package com.example.bookmyshow.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class City extends BaseModal{
    private String name;
    private List<Theatre> theatres;
}
