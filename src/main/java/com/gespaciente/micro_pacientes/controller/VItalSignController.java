package com.gespaciente.micro_pacientes.controller;

import com.gespaciente.micro_pacientes.model.VitalSign;
import com.gespaciente.micro_pacientes.service.VitalSignService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/senales-vitales")
public class VItalSignController {

    @Autowired
    private VitalSignService vitalSignService;


    @PostMapping
    public VitalSign createVitalSign(@RequestBody VitalSign vitalSign) {
        return vitalSignService.saveVitalSign(vitalSign);
    }

    @GetMapping("/{patientId}/historico")
    public List<VitalSign> getVitalSignsByPatient(@PathVariable Long patientId) {
        return vitalSignService.getVitalSignsByPatientId(patientId);
    }

    @GetMapping("/{patientId}/ultima")
    public ResponseEntity<VitalSign> getLastVitalSignByPatient(@PathVariable Long patientId) {
        List<VitalSign> vitalSigns = vitalSignService.getVitalSignsByPatientId(patientId);
        if (!vitalSigns.isEmpty()) {
            return ResponseEntity.ok(vitalSigns.get(0));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
