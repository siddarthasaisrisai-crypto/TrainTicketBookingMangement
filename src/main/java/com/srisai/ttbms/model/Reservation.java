package com.srisai.ttbms.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "reservations")
public class Reservation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String passengerName;
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "train_id", nullable = false)
	private Train train;
	@Column(nullable = false)
	private int seats;
	@Column(nullable = false)
	private String status = "CONFIRMED";
	@Column(nullable = false)
	private LocalDateTime bookedAt;

	public Reservation() {
	}

	@PrePersist
	public void beforeInsert() {
		if (bookedAt == null)
			bookedAt = LocalDateTime.now();
	}

	public Long getId() {
		return id;
	}

	public String getPassengerName() {
		return passengerName;
	}

	public void setPassengerName(String v) {
		passengerName = v;
	}

	public Train getTrain() {
		return train;
	}

	public void setTrain(Train v) {
		train = v;
	}

	public int getSeats() {
		return seats;
	}

	public void setSeats(int v) {
		seats = v;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String v) {
		status = v;
	}

	public LocalDateTime getBookedAt() {
		return bookedAt;
	}
}
