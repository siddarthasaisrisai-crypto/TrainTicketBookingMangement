package com.srisai.ttbms.dto;

import jakarta.validation.constraints.*;

public class CreateTrainRequest {
	@NotBlank
	private String trainNumber;
	@NotBlank
	private String name;
	@NotBlank
	private String source;
	@NotBlank
	private String destination;
	@Min(1)
	private int totalSeats;

	public String getTrainNumber() {
		return trainNumber;
	}

	public void setTrainNumber(String v) {
		trainNumber = v;
	}

	public String getName() {
		return name;
	}

	public void setName(String v) {
		name = v;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String v) {
		source = v;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String v) {
		destination = v;
	}

	public int getTotalSeats() {
		return totalSeats;
	}

	public void setTotalSeats(int v) {
		totalSeats = v;
	}
}
