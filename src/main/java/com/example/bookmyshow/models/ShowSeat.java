package com.example.bookmyshow.models;

import com.example.bookmyshow.models.enums.ShowSeatStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ShowSeat extends BaseModal{

    @ManyToOne
    private Show show;

    @ManyToOne
    private Seat seat;
    private ShowSeatStatus showSeatStatus;
}
