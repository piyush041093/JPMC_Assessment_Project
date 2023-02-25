package com.jpmc.util;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import com.jpmc.model.Showing;
public class TheaterUtil {
	
	
    /**
     * This method will return the total discounted price for entire booking.
     * @param movie
     * @param show
     * @param audienceCount
     * @return
     */
    public static double calculateFee(Showing show, int audienceCount) {
        return getDiscountedPrice(show) * audienceCount;
    }
    
    /**
     * This Method will calculated the discounted price of each ticket.
     * @param showing
     * @param specialCode
     * @param ticketPrice
     * @return 
     */
    public static double getDiscountedPrice(Showing showing) {
        double discount = 0;
        int hour = showing.getShowStartTime().getHour();
        double ticketPrice = showing.getMovie().getTicketPrice();
        if (Constants.MOVIE_CODE_SPECIAL == showing.getMovie().getSpecialCode()) {
        	discount = ticketPrice * Constants.SPECIAL_MOVIE_DISC;
        } if (showing.getSequenceOfTheDay() == 1) {
        	discount = Double.max(Constants.FIRST_MOVIE_DISC, discount); 
        } if (showing.getSequenceOfTheDay() == 2) {
        	discount = Double.max(Constants.SECOND_MOVIE_DISC, discount);
        } if (hour >= 11 && hour <=16){
        	discount = Double.max(ticketPrice * Constants.TIME_DISC, discount);
        } if (showing.getShowStartTime().getDayOfMonth() == Constants.SPECIAL_DAY) {
        	discount = Double.max(Constants.SPECIAL_DAY_DISC, discount);
        }
        return ticketPrice - discount;
    }
    
    /**
     * It is used to format the data which we will display.
     * @param duration
     * @return
     */
    public static String humanReadableFormat(Duration duration) {
        long hour = duration.toHours();
        long remainingMin = duration.toMinutes() - TimeUnit.HOURS.toMinutes(duration.toHours());

        return String.format("(%s hour%s %s minute%s)", hour, handlePlural(hour), remainingMin, handlePlural(remainingMin));
    }
    
    private static String handlePlural(long value) {
        if (value == 1) {
            return "";
        }
        else {
            return "s";
        }
    }
}
