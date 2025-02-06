package com.sharad.app.controller;

import com.sharad.app.model.Patient;
import com.sharad.app.service.PatientService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/patient")
public class PatientController {
    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("/get/all/patient")
    public Map<String, Patient> getAllPatients(){
        return patientService.readAllPatient();
    }

    @GetMapping("/get/patient")
    public Patient readPatientById(@RequestParam("id") String id){
        return patientService.readPatientById(id);
    }

    @PostMapping("/create/patient")
    public Patient createPatients(@RequestBody Patient patient){
        return patientService.createPatient(patient);
    }

    @PutMapping("/update/patients")
    public Patient updatePatients(@RequestParam("id") String id,@RequestParam("age") int age) {
        return patientService.updatePatient(id,age);
    }

    @DeleteMapping("/delete/patients")
    public void deletePatients(@RequestParam("id") String id) {
        patientService.deletePatient(id);
    }

}