package com.example.bookmyshow.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Seat extends BaseModal{
    private String seatNumber;
    private int row;
    private int column;
    private SeatType seatType;
}
