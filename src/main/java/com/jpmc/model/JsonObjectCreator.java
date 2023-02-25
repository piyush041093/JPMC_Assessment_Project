package com.jpmc.model;

import java.time.format.DateTimeFormatter;

import com.jpmc.util.TheaterUtil;

import lombok.Data;

/**
 * @author Piyush Chandak
 * This Class is to generate JsonObject of movie Shows.
 */
@Data
public class JsonObjectCreator {
	private int sequenceOfTheDay;
	private String showStartTime;
	private String title;
	private String duration;
	private double ticketPrice;

	/**
	 * This method will create the json object from Showing class
	 * @param show
	 */
	public JsonObjectCreator(Showing show) {
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		Movie movie = show.getMovie();
		this.sequenceOfTheDay = show.getSequenceOfTheDay();
		this.showStartTime = show.getShowStartTime().format(dateTimeFormatter);
		this.title = movie.getTitle();
		this.duration = TheaterUtil.humanReadableFormat(movie.getRunningTime());
		this.ticketPrice = movie.getTicketPrice();
	}
}
