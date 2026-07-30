package com.example.bookmyshow.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GetBookingResponseDTO {
    private List<BookingResponseDTO> bookings;
    private ResponseStatus responseStatus;
}
