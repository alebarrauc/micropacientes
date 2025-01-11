package com.gespaciente.micro_pacientes.controller;

import com.gespaciente.micro_pacientes.model.Alert;
import com.gespaciente.micro_pacientes.service.AlertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alertas")
public class AlertController {

    @Autowired
    private AlertService alertService;

    @PostMapping
    public Alert createAlert(@RequestBody Alert alert) {
        return alertService.saveAlert(alert);
    }

    @GetMapping("/{patientId}")
    public List<Alert> getAlertsByPatient(@PathVariable Long patientId) {
        return alertService.getAlertsByPatientId(patientId);
    }

    @PutMapping("/{alertId}/resolver")
    public ResponseEntity<Alert> resolveAlert(@PathVariable Long alertId) {
        return alertService.getAlertById(alertId)
                .map(alert -> {
                    alert.setStatus("Resuelta");
                    return ResponseEntity.ok(alertService.saveAlert(alert));
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
