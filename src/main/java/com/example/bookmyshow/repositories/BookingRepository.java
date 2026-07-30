package com.example.bookmyshow.repositories;

import com.example.bookmyshow.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    Booking save (Booking booking);
    List<Booking> findAllByUserId(Long userId);
}
