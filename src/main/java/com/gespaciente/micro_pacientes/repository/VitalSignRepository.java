package com.gespaciente.micro_pacientes.repository;

import com.gespaciente.micro_pacientes.model.VitalSign;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VitalSignRepository extends JpaRepository<VitalSign, Long> {
    List<VitalSign> findByPatientIdOrderByTimestampDesc(Long patientId);
}
