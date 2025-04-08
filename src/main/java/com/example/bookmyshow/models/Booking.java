package com.example.bookmyshow.models;


import com.example.bookmyshow.models.enums.BookingStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
public class Booking extends BaseModal{
    @ManyToOne
    private User user;
    private BookingStatus bookingStatus;

    @OneToMany
    private List<ShowSeat> showSeats;

    private double amount;

    @OneToMany
    private List<Payment> payments;

    private Date bookedAt;
}
