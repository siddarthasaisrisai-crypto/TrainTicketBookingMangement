package com.srisai.ttbms.service;

import com.srisai.ttbms.dao.TrainDao;
import com.srisai.ttbms.dto.CreateTrainRequest;
import com.srisai.ttbms.model.Train;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class TrainService {
	private final TrainDao dao;

	public TrainService(TrainDao dao) {
		this.dao = dao;
	}

	public List<Train> getAll() {
		return dao.findAll();
	}

	public Train getById(Long id) {
		return dao.findById(id).orElseThrow(() -> new IllegalArgumentException("Train not found: " + id));
	}

	@Transactional
	public Train create(CreateTrainRequest r) {
		if (dao.existsByTrainNumber(r.getTrainNumber()))
			throw new IllegalArgumentException("Train number already exists.");
		Train t = new Train();
		t.setTrainNumber(r.getTrainNumber().trim());
		t.setName(r.getName().trim());
		t.setSource(r.getSource().trim());
		t.setDestination(r.getDestination().trim());
		t.setTotalSeats(r.getTotalSeats());
		return dao.save(t);
	}
}
