package com.srisai.ttbms.dao;
import com.srisai.ttbms.model.Train;
import org.springframework.data.jpa.repository.JpaRepository;
public interface TrainDao extends JpaRepository<Train, Long> { boolean existsByTrainNumber(String trainNumber); }
