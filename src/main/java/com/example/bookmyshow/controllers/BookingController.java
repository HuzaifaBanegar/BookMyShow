package com.example.bookmyshow.controllers;

import com.example.bookmyshow.dtos.*;
import com.example.bookmyshow.dtos.ResponseStatus;
import com.example.bookmyshow.exceptions.ShowSeatNotAvailableException;
import com.example.bookmyshow.exceptions.UserNotFoundException;
import com.example.bookmyshow.models.Booking;
import com.example.bookmyshow.models.ShowSeat;
import com.example.bookmyshow.services.BookingService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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
                .amount(booking.getAmount()).
                showId(booking.getShowSeats().get(0).getShow().getId())
                .seatIds(
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

    @GetMapping("/{id}")
    public GetBookingResponseDTO getBooking(@PathVariable Long id){
        GetBookingResponseDTO responseDTO = new GetBookingResponseDTO();
        List<Booking> bookings = bookingService.getBookingByUserId(id);
        if(bookings.isEmpty()){
            responseDTO.setBookings(null);
            responseDTO.setResponseStatus(ResponseStatus.SUCCESS);
            return responseDTO;
        }

        List<BookingResponseDTO> bookingResponseDTOS= new ArrayList<>();

        for(Booking booking : bookings){
            BookingResponseDTO bookingResponse = BookingResponseDTO.builder()
                    .bookingId(booking.getId())
                    .userId(booking.getUser().getId())
                    .bookingStatus(booking.getBookingStatus())
                    .amount(booking.getAmount()).
                    showId(booking.getShowSeats().get(0).getShow().getId())
                    .seatIds(
                            booking.getShowSeats()
                                    .stream()
                                    .map(ShowSeat::getId)
                                    .toList()
                    )
                    .build();

            bookingResponseDTOS.add(bookingResponse);
        }



        responseDTO.setBookings(bookingResponseDTOS);
        responseDTO.setResponseStatus(ResponseStatus.SUCCESS);

        return responseDTO;

    }

}
