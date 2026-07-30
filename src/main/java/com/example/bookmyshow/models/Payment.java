package com.example.bookmyshow.models;

import com.example.bookmyshow.models.enums.PaymentMode;
import com.example.bookmyshow.models.enums.PaymentStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="payments")
public class Payment extends BaseModal{
    private String referenceId;
    private Double amount;

    @Enumerated(EnumType.ORDINAL)// this will be enum marked as 0,1,2
    private PaymentMode paymentMode;

    @Enumerated(EnumType.ORDINAL)
    private PaymentStatus paymentStatus;
}
