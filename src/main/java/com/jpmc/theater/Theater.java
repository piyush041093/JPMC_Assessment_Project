package com.jpmc.theater;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.jpmc.model.Customer;
import com.jpmc.model.JsonObjectCreator;
import com.jpmc.model.Movie;
import com.jpmc.model.Reservation;
import com.jpmc.model.Showing;

public class Theater {

    static LocalDateProvider provider;
    private List<Showing> schedule;

    public Theater(LocalDateProvider provider) {
        this.provider = provider;

        Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90), 12.5, 1);
        Movie turningRed = new Movie("Turning Red", Duration.ofMinutes(85), 11, 0);
        Movie theBatMan = new Movie("The Batman", Duration.ofMinutes(95), 9, 0);
        schedule = Stream.of(
            new Showing(turningRed, 1, LocalDateTime.of(provider.currentDate(), LocalTime.of(9, 0))),
            new Showing(spiderMan, 2, LocalDateTime.of(provider.currentDate(), LocalTime.of(11, 0))),
            new Showing(theBatMan, 3, LocalDateTime.of(provider.currentDate(), LocalTime.of(12, 50))),
            new Showing(turningRed, 4, LocalDateTime.of(provider.currentDate(), LocalTime.of(14, 30))),
            new Showing(spiderMan, 5, LocalDateTime.of(provider.currentDate(), LocalTime.of(16, 10))),
            new Showing(theBatMan, 6, LocalDateTime.of(provider.currentDate(), LocalTime.of(17, 50))),
            new Showing(turningRed, 7, LocalDateTime.of(provider.currentDate(), LocalTime.of(19, 30))),
            new Showing(spiderMan, 8, LocalDateTime.of(provider.currentDate(), LocalTime.of(21, 10))),
            new Showing(theBatMan, 9, LocalDateTime.of(provider.currentDate(), LocalTime.of(23, 0))))
            .collect(Collectors.toList());
    }

	public List<Showing> getSchedule() {
		return schedule;
	}

	/**
	 * This method will reserve the seats
	 * @param customer
	 * @param sequence
	 * @param howManyTickets
	 * @return
	 */
	public Reservation reserve(Customer customer, int sequence, int howManyTickets) {
        Showing showing;
        try {
            showing = schedule.get(sequence - 1);
        } catch (RuntimeException ex) {
            ex.printStackTrace();
            throw new IllegalStateException("not able to find any showing for given sequence " + sequence);
        }
        return new Reservation(customer, showing, howManyTickets);
    }

    public void printSchedule() {
        System.out.println(provider.currentDate());
        System.out.println("===================================================");
        schedule.forEach(s ->
                System.out.println(s.getSequenceOfTheDay() + ": " + s.getShowStartTime() + " " + s.getMovie().getTitle() + " " + s.getDuration() + " $" + s.getMovie().getTicketPrice())
        );
        System.out.println("===================================================");
    }

    public static void main(String[] args) {
    	// It will print the data in test format
        Theater theater = new Theater(LocalDateProvider.singleton());
        theater.printSchedule();
        
        // It will print the data in Json format
        Gson gson = new GsonBuilder().create();
        JsonObject  obj =  new JsonObject();
        ArrayList<String> movieList = new ArrayList<String>();
        obj.addProperty("Date", provider.currentDate().toString());
        for (Showing show : theater.getSchedule()) {
        	movieList.add(gson.toJson(new JsonObjectCreator(show)));
        }
        obj.addProperty("Movies", movieList.toString());
        System.out.println(obj);
    }
}
