package com.jpmc.model;

import java.time.LocalDateTime;

import com.jpmc.util.TheaterUtil;

import lombok.Getter;

/**
 * @author Piyush Chandak
 * This Class stores show details.
 */
@Getter
public class Showing {
	
	private  Movie movie;
	private int sequenceOfTheDay;
	private LocalDateTime showStartTime;
	private String duration;

	public Showing(Movie movie, int sequenceOfTheDay, LocalDateTime showStartTime) {
		this.movie = movie;
		this.sequenceOfTheDay = sequenceOfTheDay;
		this.showStartTime = showStartTime;
		this.duration = TheaterUtil.humanReadableFormat(this.movie.getRunningTime());
	}
	
}
