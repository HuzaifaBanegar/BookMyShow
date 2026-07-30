package com.example.bookmyshow.services;

import com.example.bookmyshow.exceptions.ShowSeatNotAvailableException;
import com.example.bookmyshow.exceptions.UserNotFoundException;
import com.example.bookmyshow.models.Booking;
import com.example.bookmyshow.models.ShowSeat;
import com.example.bookmyshow.models.User;
import com.example.bookmyshow.models.enums.BookingStatus;
import com.example.bookmyshow.models.enums.ShowSeatStatus;
import com.example.bookmyshow.repositories.BookingRepository;
import com.example.bookmyshow.repositories.ShowSeatRepository;
import com.example.bookmyshow.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {
    private UserRepository userRepository;
    private ShowSeatRepository showSeatRepository;
    private BookingPriceCalculatorService bookingPriceCalculatorService;
    private BookingRepository bookingRepository;
    public BookingService(UserRepository userRepository, ShowSeatRepository showSeatRepository, BookingRepository bookingRepository, BookingPriceCalculatorService bookingPriceCalculatorService) {
        this.userRepository = userRepository;
        this.showSeatRepository= showSeatRepository;
        this.bookingPriceCalculatorService = bookingPriceCalculatorService;
        this.bookingRepository = bookingRepository;
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    /*
        1. Fetch the user form userId
        2. If the user is not found, then throw the exception
        3. Fetch the showSeat object from database
        4. Check if showSeat is available
        5. If available, block the seat
        6. Calculate the entire amount for booking
        6. Create a booking for that user and return the Booking back to the client.
        */
    public Booking createBooking(Long userId, List<Long> showSeatIds) throws UserNotFoundException, ShowSeatNotAvailableException {
        Optional<User> optionalUser = userRepository.findById(userId);
        if(optionalUser.isEmpty()){
            throw new UserNotFoundException("User with id " + userId + " not found");
        }

        User user = optionalUser.get();
        List<ShowSeat> showSeats = showSeatRepository.findAllById(showSeatIds);

        for(ShowSeat showSeat : showSeats){
            if(!showSeat.getShowSeatStatus().equals(ShowSeatStatus.AVAILABLE)){
                throw new ShowSeatNotAvailableException("Show seat with showId: "+ showSeat.getShow().getId() +" and seatId: "+showSeat.getSeat() +" is not available");
            }
        }

        for(ShowSeat showSeat : showSeats){
            showSeat.setShowSeatStatus(ShowSeatStatus.BLOCKED);
            showSeatRepository.save(showSeat); // Save in database
        }

        Booking booking = new Booking();
        booking.setShowSeats(showSeats);
        booking.setBookingStatus(BookingStatus.PENDING);
        booking.setUser(user);
        booking.setAmount(bookingPriceCalculatorService.calculateBookingPrice(showSeats));


        return bookingRepository.save(booking);

    }

    public List<Booking> getBookingByUserId(Long userId){
        List<Booking> bookings = bookingRepository.findAllByUserId(userId);
        if(bookings.isEmpty()){
            return null;
        }
        return bookings;


    }
}
