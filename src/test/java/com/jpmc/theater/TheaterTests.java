package com.jpmc.theater;

import org.junit.jupiter.api.Test;

import com.jpmc.model.Customer;
import com.jpmc.model.Reservation;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TheaterTests {
	
	
    @Test
    void totalFeeForCustomer() {
        Theater theater = new Theater(LocalDateProvider.singleton());
        Customer john = new Customer();
        john.setName("John Doe;");
        john.setId("unused-id");
        Reservation reservation = theater.reserve(john, 2, 4);
        assertEquals(37.5, reservation.getTotalFee());
    }

    @Test
    void printMovieSchedule() {
        Theater theater = new Theater(LocalDateProvider.singleton());
        theater.printSchedule();
    }
}
