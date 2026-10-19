package com.srisai.ttbms.controller;

import com.srisai.ttbms.dto.CreateTrainRequest;
import com.srisai.ttbms.model.Train;
import com.srisai.ttbms.service.TrainService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/trains")
public class TrainController {
	private final TrainService service;

	public TrainController(TrainService service) {
		this.service = service;
	}

	@GetMapping
	public List<Train> getAll() {
		return service.getAll();
	}

	@GetMapping("/{id}")
	public Train getById(@PathVariable Long id) {
		return service.getById(id);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Train create(@Valid @RequestBody CreateTrainRequest r) {
		return service.create(r);
	}
}
