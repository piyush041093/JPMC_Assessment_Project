package com.jpmc.theater;

import org.junit.jupiter.api.Test;

import com.jpmc.model.Customer;
import com.jpmc.model.Movie;
import com.jpmc.model.Reservation;
import com.jpmc.model.Showing;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ReservationTests {

    @Test
    void totalFee() {
    	Customer customer = new Customer();
        customer.setName("John Doe;");
        customer.setId("unused-id");
        Showing showing = new Showing(
                new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90), 12.5, 1),
                1,
                LocalDateTime.of(2022, Month.MAY, 17, 9, 33)
        );
        assertTrue(new Reservation(customer, showing, 3).getTotalFee() == 28.5);
    }
    
    @Test
    void testFeeWhithAllDisc() {
    	Customer customer = new Customer();
        customer.setName("John Doe;");
        customer.setId("unused-id");
        Showing showing = new Showing(
                new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90), 20, 1),
                1,
                LocalDateTime.of(2022, Month.MAY, 7, 14, 33)
        );
        assertTrue(new Reservation(customer, showing, 2).getTotalFee() == 30);
    }
}
