package com.srisai.ttbms.service;

import com.srisai.ttbms.dao.*;
import com.srisai.ttbms.dto.CreateReservationRequest;
import com.srisai.ttbms.model.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class ReservationService {
	private final ReservationDao reservations;
	private final TrainDao trains;

	public ReservationService(ReservationDao r, TrainDao t) {
		reservations = r;
		trains = t;
	}

	public List<Reservation> getAll() {
		return reservations.findAll();
	}

	@Transactional
	public Reservation book(CreateReservationRequest r) {
		if (r.getSeats() < 1)
			throw new IllegalArgumentException("Seats must be at least 1.");
		Train train = trains.findById(r.getTrainId())
				.orElseThrow(() -> new IllegalArgumentException("Train not found: " + r.getTrainId()));
		if (train.getAvailableSeats() < r.getSeats())
			throw new IllegalArgumentException("Not enough seats available.");
		train.setAvailableSeats(train.getAvailableSeats() - r.getSeats());
		trains.save(train);
		Reservation b = new Reservation();
		b.setPassengerName(r.getPassengerName().trim());
		b.setTrain(train);
		b.setSeats(r.getSeats());
		b.setStatus("CONFIRMED");
		return reservations.save(b);
	}

	@Transactional
	public void cancel(Long id) {
		Reservation b = reservations.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Reservation not found: " + id));
		if ("CANCELLED".equals(b.getStatus()))
			throw new IllegalArgumentException("Reservation is already cancelled.");
		Train t = b.getTrain();
		t.setAvailableSeats(Math.min(t.getTotalSeats(), t.getAvailableSeats() + b.getSeats()));
		trains.save(t);
		b.setStatus("CANCELLED");
		reservations.save(b);
	}
}
