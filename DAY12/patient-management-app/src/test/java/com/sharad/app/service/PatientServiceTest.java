package com.sharad.app.service;

import com.sharad.app.controller.PatientControllerTest;
import com.sharad.app.model.Patient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Map;

@RunWith(MockitoJUnitRunner.class)
public class PatientServiceTest {
    @InjectMocks
    PatientService patientService;

    @Test
    public void testCreatePatient() {
        Patient patient = new Patient("Pat1", "1", "Hospital", 25, "M");
        Patient expectedPatient=patientService.createPatient(patient);
        assert expectedPatient != null;
        assert expectedPatient.getId()== patient.getId();
        assert expectedPatient.getAge() == patient.getAge();
        assert expectedPatient.getName() == patient.getName();
        assert expectedPatient.getHospitalName() == patient.getHospitalName();
        assert expectedPatient.getGender() == patient.getGender();
    }

    @Test
    public void testUpdatePatient() {
        Patient patient = new Patient("Pat1", "1", "Hospital", 25, "M");
        Patient expectedPatient=patientService.createPatient(patient);
        Patient resultPatient=patientService.updatePatient(patient.getId(), 30);
        assert resultPatient != null;
        assert resultPatient.getId()== patient.getId();
        assert resultPatient.getAge()== 30;
        assert resultPatient.getName()== patient.getName();
        assert resultPatient.getHospitalName()== patient.getHospitalName();
        assert resultPatient.getGender()== patient.getGender();
    }

    @Test
    public void testReadReadAllPatient() {
        Patient patient1 = new Patient("Pat1", "1", "Hospital1", 21, "M");
        Patient patient2 = new Patient("Pat2", "2", "Hospital2", 23, "F");
        Patient patient3 = new Patient("Pat3", "3", "Hospital3", 25, "M");
        patientService.createPatient(patient1);
        patientService.createPatient(patient2);
        patientService.createPatient(patient3);
        Map<String, Patient> resultPatients = patientService.readAllPatient();
        assert resultPatients.size()==3;
        assert resultPatients.containsKey(patient1.getId());
        assert resultPatients.containsKey(patient2.getId());
        assert resultPatients.containsKey(patient3.getId());
    }

    @Test
    public void testDeletePatient() {
        Patient patient1 = new Patient("Pat1", "1", "Hospital1", 21, "M");
        Patient expectedPatient = patientService.createPatient(patient1);
        patientService.deletePatient(patient1.getId());
        Patient expectedResult = patientService.readPatientById(patient1.getId());
        assert expectedResult == null;
    }
}