package com.example.bookmyshow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="seats")
public class Seat extends BaseModal{
    private String seatNumber;
    private int row;
    private int column;

    @ManyToOne
    private SeatType seatType;
}
