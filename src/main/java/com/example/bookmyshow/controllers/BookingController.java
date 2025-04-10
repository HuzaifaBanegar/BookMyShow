package com.example.bookmyshow.controllers;

import com.example.bookmyshow.dtos.CreateBookingRequestDTO;
import com.example.bookmyshow.dtos.CreateBookingResponseDTO;
import com.example.bookmyshow.dtos.ResponseStatus;
import com.example.bookmyshow.models.Booking;
import com.example.bookmyshow.services.BookingService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bookings")
public class BookingController {
    private BookingService bookingService;
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }
    @PostMapping
    public CreateBookingResponseDTO createBooking(@RequestBody CreateBookingRequestDTO requestDTO) {
        CreateBookingResponseDTO responseDTO = new CreateBookingResponseDTO();

        Booking booking = bookingService.createBooking(
                requestDTO.getUserId(),
                requestDTO.getShowseatsIds()
        );

        responseDTO.setBooking(booking);
        responseDTO.setResponseStatus(ResponseStatus.SUCCESS);

        if(booking == null) {
            responseDTO.setResponseStatus(ResponseStatus.FAILURE);
        }

        return responseDTO;

    }
}
