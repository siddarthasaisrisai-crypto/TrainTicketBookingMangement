package com.srisai.ttbms.controller;

import com.srisai.ttbms.dto.CreateReservationRequest;
import com.srisai.ttbms.model.Reservation;
import com.srisai.ttbms.service.ReservationService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {
	private final ReservationService service;

	public ReservationController(ReservationService service) {
		this.service = service;
	}

	@GetMapping
	public List<Reservation> getAll() {
		return service.getAll();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Reservation book(@Valid @RequestBody CreateReservationRequest r) {
		return service.book(r);
	}

	@DeleteMapping("/{id}")
	public Map<String, String> cancel(@PathVariable Long id) {
		service.cancel(id);
		return Map.of("message", "Reservation cancelled", "reservationId", id.toString());
	}
}
