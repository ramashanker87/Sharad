package com.sharad.app.controller;

import com.sharad.app.model.Patient;
import com.sharad.app.service.DoctorReceiver;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import software.amazon.awssdk.services.sqs.model.MessageAttributeValue;
import software.amazon.awssdk.utils.Pair;

import java.util.Map;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
    private final DoctorReceiver doctorReceiver;

    public DoctorController(DoctorReceiver doctorReceiver) {
        this.doctorReceiver = doctorReceiver;
    }

    @Value("${amazon.aws.sqs.queue}")
    private String queue;

    @GetMapping("/receive")
    public ResponseEntity<Patient> receive() throws ExecutionException, InterruptedException, JsonProcessingException {
        Pair<Patient, Map<String, MessageAttributeValue>> message=doctorReceiver.consumeMessage(queue, Patient.class);
        Patient patient = message.left();
        Map<String, MessageAttributeValue> messageAttributes=message.right();
        HttpHeaders headers = new HttpHeaders();
        messageAttributes.forEach((key, value) ->{
            if(value.stringValue()!=null){
                headers.add(key,value.stringValue());
            }
        });
        return new ResponseEntity<>(patient,headers, HttpStatus.CREATED);

    }
}