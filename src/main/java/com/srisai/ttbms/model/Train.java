package com.srisai.ttbms.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "trains")
public class Train {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	@Column(nullable = false, unique = true)
	private String trainNumber;
	@NotBlank
	@Column(nullable = false)
	private String name;
	@NotBlank
	@Column(nullable = false)
	private String source;
	@NotBlank
	@Column(nullable = false)
	private String destination;
	@Min(1)
	@Column(nullable = false)
	private int totalSeats;
	@Column(nullable = false)
	private int availableSeats;

	public Train() {
	}

	public Long getId() {
		return id;
	}

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
		availableSeats = v;
	}

	public int getAvailableSeats() {
		return availableSeats;
	}

	public void setAvailableSeats(int v) {
		availableSeats = v;
	}
}
