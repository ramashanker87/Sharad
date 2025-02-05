package com.sharad.app.controller;

import com.sharad.app.controller.PatientController;
import com.sharad.app.model.Patient;
import com.sharad.app.service.PatientService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class PatientControllerTest {
    @InjectMocks
    PatientController patientController;
    @Mock
    PatientService patientService;

    @Test
    public void testGetAllPatients() {
        Map<String, Patient> patientMap = new HashMap<>();
        Patient patient1 = new Patient("Pat1", "1", "Hospital1", 21, "M");
        Patient patient2 = new Patient("Pat2", "2", "Hospital2", 24, "M");
        Patient patient3 = new Patient("Pat3", "3", "Hospital3", 27, "F");
        patientMap.put(patient1.getId(), patient1);
        patientMap.put(patient2.getId(), patient2);
        patientMap.put(patient3.getId(), patient3);
        when(patientService.readAllPatient()).thenReturn(patientMap);
        Map<String, Patient> patientResultMap = patientController.getAllPatients();
        assert patientResultMap!=null;
        assert patientResultMap.size()==3;
        assert patientResultMap.get(patient1.getId())==patient1;
        assert patientResultMap.get(patient2.getId())==patient2;
        assert patientResultMap.get(patient3.getId())==patient3;
    }

    @Test
    public void testGetPatientByName() {
        Map<String, Patient> patientMap = new HashMap<>();
        Patient patient1 = new Patient("Pat1", "1", "Hospital1", 21, "M");
        Patient patient2 = new Patient("Pat2", "2", "Hospital2", 24, "M");
        patientMap.put(patient1.getName(), patient1);
        patientMap.put(patient2.getName(), patient2);
        when(patientService.readPatientById(anyString())).thenReturn(patient1);
        Patient resultPatient = patientController.readPatientById(patient1.getName());
        assert resultPatient != null;
        assert resultPatient.getName().equals("Pat1");
    }

    @Test
    public void testCreatePatients(){
        Patient patient1 = new Patient("Pat1", "1", "Hospital1", 21, "M");
        when(patientService.createPatient(patient1)).thenReturn(patient1);
        Patient resultPatient=patientController.createPatients(patient1);
        assert resultPatient!=null;
        assert resultPatient.getId()==patient1.getId();
        assert resultPatient.getName().equals("Pat1");
        assert resultPatient.getHospitalName().equals("Hospital1");
        assert resultPatient.getAge()==21;
        assert resultPatient.getGender().equals("M");

    }

    @Test
    public void testUpdatePatients(){
        Patient patient1 = new Patient("Pat1", "1", "Hospital1", 21, "M");
        Patient patient2 = new Patient("Pat2", "2", "Hospital2", 23, "F");
        when(patientService.updatePatient(anyString(),anyInt())).thenReturn(patient2);
        Patient resultPatient = patientController.updatePatients(patient1.getId(),23);
        assert resultPatient!=null;
        assert resultPatient.getId()==patient2.getId();
        assert resultPatient.getName().equals("Pat2");
        assert resultPatient.getHospitalName().equals("Hospital2");
        assert resultPatient.getAge()==23;
        assert resultPatient.getGender().equals("F");
    }

    @Test
    public void testDeletePatients(){
        doNothing().when(patientService).deletePatient(anyString());
        patientController.deletePatients("1");
        verify(patientService, atLeast(1)).deletePatient(anyString());
    }

}