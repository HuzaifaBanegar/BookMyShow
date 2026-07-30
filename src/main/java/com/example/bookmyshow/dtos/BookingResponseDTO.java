package com.example.bookmyshow.dtos;

import com.example.bookmyshow.models.enums.BookingStatus;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class BookingResponseDTO {
    private Long bookingId;
    private Long userId;
    private BookingStatus bookingStatus;
    private double amount;
    private Long showId;
    private List<Long> seatIds;
}