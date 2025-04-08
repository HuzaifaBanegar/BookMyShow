package com.example.bookmyshow.models;

import com.example.bookmyshow.models.enums.Feature;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class Show extends BaseModal{
    private Movie movie;
    private Date startTime;
    private Date endTime;
    private List<Screen> screens;
    private Feature feature;
}
