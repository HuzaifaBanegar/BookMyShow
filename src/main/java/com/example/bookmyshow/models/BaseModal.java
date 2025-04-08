package com.example.bookmyshow.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class BaseModal {
    private Long id;
    private Date createdAt;
    private Date updatedAt;
}
