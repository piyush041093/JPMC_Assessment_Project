package com.jpmc.theater;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Month;

import org.junit.jupiter.api.Test;

import com.jpmc.model.Movie;
import com.jpmc.model.Showing;
import com.jpmc.util.TheaterUtil;

public class MovieTests {
    @Test
    void specialMovieWith50PercentDiscount() {
        Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90),12.5, 1);
        Showing showing = new Showing(spiderMan, 5, LocalDateTime.of(2022, Month.MAY, 7, 10, 33));
        assertEquals(10, TheaterUtil.getDiscountedPrice(showing));

    }
}
