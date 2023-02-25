package com.jpmc.model;

import java.time.Duration;
import java.util.Objects;

import lombok.Getter;

/**
 * @author Piyush Chandak
 * This Class Stores Movie Details
 */
@Getter
public class Movie {

    private String title;
    private String description;
    private transient Duration runningTime;
    private double ticketPrice;
    private int specialCode;

    /**
     * Constructor to create movie object
     * @param title
     * @param runningTime
     * @param ticketPrice
     * @param specialCode
     */
    public Movie(String title, Duration runningTime, double ticketPrice, int specialCode) {
        this.title = title;
        this.runningTime = runningTime;
        this.ticketPrice = ticketPrice;
        this.specialCode = specialCode;
    }



}