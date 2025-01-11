package com.gespaciente.micro_pacientes.repository;

import com.gespaciente.micro_pacientes.model.Alert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlertRepository extends JpaRepository<Alert, Long> {
    List<Alert> findByPatientIdOrderByTimestampDesc(Long patientId);
}
