package com.example.bookmyshow.models;

import com.example.bookmyshow.models.enums.ShowSeatStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShowSeat extends BaseModal{
    private Show show;
    private Seat seat;
    private ShowSeatStatus showSeatStatus;
}
