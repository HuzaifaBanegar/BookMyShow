package com.example.bookmyshow.services;

import com.example.bookmyshow.models.Seat;
import com.example.bookmyshow.models.Show;
import com.example.bookmyshow.models.ShowSeat;
import com.example.bookmyshow.models.ShowSeatType;
import com.example.bookmyshow.repositories.ShowSeatTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingPriceCalculatorService {
    ShowSeatTypeRepository showSeatTypeRepository;
    public BookingPriceCalculatorService(ShowSeatTypeRepository showSeatTypeRepository) {
        this.showSeatTypeRepository = showSeatTypeRepository;
    }
    public double calculateBookingPrice(List<ShowSeat> showSeats){
        double bookingPrice = 0.0;

        Long showId = showSeats.get(0).getShow().getId();
        List<Seat> seats = showSeats.stream().map(ShowSeat::getSeat).toList();

        List<ShowSeatType> allShowSeatTypes = showSeatTypeRepository.findAllByShowId(showId);

        for(ShowSeatType showSeatType : allShowSeatTypes){
            if(seats.contains(showSeatType.getSeat())){
                bookingPrice += showSeatType.getPrice();
            }
        }

        return bookingPrice;

    }
}
