package com.example.bookmyshow.controllers;

import com.example.bookmyshow.dtos.BookingResponseDTO;
import com.example.bookmyshow.dtos.CreateBookingRequestDTO;
import com.example.bookmyshow.dtos.CreateBookingResponseDTO;
import com.example.bookmyshow.dtos.ResponseStatus;
import com.example.bookmyshow.exceptions.ShowSeatNotAvailableException;
import com.example.bookmyshow.exceptions.UserNotFoundException;
import com.example.bookmyshow.models.Booking;
import com.example.bookmyshow.models.ShowSeat;
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
    @PostMapping("/create")
    public CreateBookingResponseDTO createBooking(@RequestBody CreateBookingRequestDTO requestDTO) throws UserNotFoundException, ShowSeatNotAvailableException {


        Booking booking = bookingService.createBooking(
                requestDTO.getUserId(),
                requestDTO.getShowseatsIds()
        );

        BookingResponseDTO bookingResponse = BookingResponseDTO.builder()
                .bookingId(booking.getId())
                .userId(booking.getUser().getId())
                .bookingStatus(booking.getBookingStatus())
                .amount(booking.getAmount())
                .showSeatIds(
                        booking.getShowSeats()
                                .stream()
                                .map(ShowSeat::getId)
                                .toList()
                )
                .build();

        CreateBookingResponseDTO responseDTO = new CreateBookingResponseDTO();
        responseDTO.setBooking(bookingResponse);
        responseDTO.setResponseStatus(ResponseStatus.SUCCESS);

        if(booking == null) {
            responseDTO.setResponseStatus(ResponseStatus.FAILURE);
        }

        return responseDTO;

    }
}
