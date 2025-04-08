package com.example.bookmyshow.models;

import com.example.bookmyshow.models.enums.PaymentMode;
import com.example.bookmyshow.models.enums.PaymentStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Payment extends BaseModal{
    private String referenceId;
    private Double amount;
    private PaymentMode paymentMode;
    private PaymentStatus paymentStatus;
}
