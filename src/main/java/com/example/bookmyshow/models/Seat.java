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
    private int row_no;
    private int col_no;

    @ManyToOne
    private SeatType seatType;
}
