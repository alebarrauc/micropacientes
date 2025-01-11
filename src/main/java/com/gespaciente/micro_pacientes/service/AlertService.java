package com.gespaciente.micro_pacientes.service;

import com.gespaciente.micro_pacientes.model.Alert;
import com.gespaciente.micro_pacientes.repository.AlertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlertService {

    @Autowired
    private AlertRepository alertRepository;

    public List<Alert> getAlertsByPatientId(Long patientId) {
        return alertRepository.findByPatientIdOrderByTimestampDesc(patientId);
    }

    public Alert saveAlert(Alert alert) {
        return alertRepository.save(alert);
    }

    public Optional<Alert> getAlertById(Long alertId) {
        return alertRepository.findById(alertId);
    }
}
