package com.gespaciente.micro_pacientes.service;

import com.gespaciente.micro_pacientes.model.VitalSign;
import com.gespaciente.micro_pacientes.repository.VitalSignRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VitalSignService {

    @Autowired
    private VitalSignRepository vitalSignRepository;

    public List<VitalSign> getVitalSignsByPatientId(Long patientId) {
        return vitalSignRepository.findByPatientIdOrderByTimestampDesc(patientId);
    }

    public VitalSign saveVitalSign(VitalSign vitalSign) {
        return vitalSignRepository.save(vitalSign);
    }
}
