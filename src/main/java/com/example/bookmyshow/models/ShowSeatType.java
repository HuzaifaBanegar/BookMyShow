package com.example.bookmyshow.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShowSeatType extends BaseModal{
    private Show show;
    private Seat seat;
    private Double price;
}
