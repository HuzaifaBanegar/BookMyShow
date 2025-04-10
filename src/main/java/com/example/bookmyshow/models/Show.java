package com.example.bookmyshow.models;

import com.example.bookmyshow.models.enums.Feature;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity(name = "shows")
public class Show extends BaseModal{
    @ManyToOne
    private Movie movie;
    private Date startTime;
    private Date endTime;

    @ManyToOne
    private Screen screens;

    @Enumerated(EnumType.ORDINAL)
    @ElementCollection
    private List<Feature> feature;
}
