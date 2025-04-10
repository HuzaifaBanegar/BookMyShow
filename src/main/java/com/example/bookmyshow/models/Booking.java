package com.example.bookmyshow.models;


import com.example.bookmyshow.models.enums.BookingStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity(name="bookings")
public class Booking extends BaseModal{
    @ManyToOne
    private User user;

    @Enumerated(EnumType.ORDINAL)
    private BookingStatus bookingStatus;

    @OneToMany
    @JoinColumn(name="booking_id")
    private List<ShowSeat> showSeats;

    private double amount;

    @OneToMany
    @JoinColumn(name="booking_id")
    private List<Payment> payments;

    private Date bookedAt;
}
