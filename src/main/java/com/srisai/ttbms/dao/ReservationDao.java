package com.srisai.ttbms.dao;
import com.srisai.ttbms.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ReservationDao extends JpaRepository<Reservation, Long> {}
