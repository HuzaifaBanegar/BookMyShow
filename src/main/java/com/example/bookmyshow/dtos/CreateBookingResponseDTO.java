package com.example.bookmyshow.dtos;

import com.example.bookmyshow.models.Booking;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateBookingResponseDTO {
    private Booking booking;
    private ResponseStatus responseStatus;
}
