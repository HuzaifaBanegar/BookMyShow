package com.example.bookmyshow.models;


import com.example.bookmyshow.models.enums.BookingStatus;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class Booking extends BaseModal{
    private User user;
    private BookingStatus bookingStatus;
    private List<ShowSeat> showSeats;
    private double amount;
    private List<Payment> payments;
    private Date bookedAt;
}
