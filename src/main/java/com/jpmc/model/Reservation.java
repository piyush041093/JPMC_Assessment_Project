package com.jpmc.model;

import com.jpmc.util.TheaterUtil;

/**
 * @author Piyush Chandak
 * This Class is used for reservation.
 */
public class Reservation {
    private Customer customer;
    private Showing showing;
    private int audienceCount;

    public Reservation(Customer customer, Showing showing, int audienceCount) {
        this.customer = customer;
        this.showing = showing;
        this.audienceCount = audienceCount;
    }

    /**
     * This method calculate total amount customer needs to pay.
     * @return total amount payable.
     */
    public double getTotalFee() {
        return TheaterUtil.calculateFee(showing, audienceCount);
    }
}