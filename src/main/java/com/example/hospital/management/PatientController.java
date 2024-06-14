package com.example.hospital.management;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {
    HashMap<Integer,Patient> patientDb=new HashMap<>();
   @PostMapping("/addViaParameters")
   public String addPatient(@RequestParam("patientId")Integer patientId, @RequestParam("name") String name,@RequestParam("age")Integer age,@RequestParam("disease")String disease){
       Patient patient=new Patient(patientId,name,disease,age);
       patientDb.put(patientId,patient);

       return "Patient added successfully";
   }@PostMapping("/addViaRequestBody")
    public String addPatient(@RequestBody Patient patient){
       int key=patient.getPatientId();
       patientDb.put(key,patient);
       return "patient added via request Body";
    }
    @GetMapping("/getInfoViaPathVariable{patientId}")
    public Patient getPatientInfo(@PathVariable("PatientId")Integer patientId){
       Patient patient=patientDb.get(patientId);
       return patient;
    }
    @GetMapping("/getPatients/{age}/{disease}")
    public List<Patient> getAgeGraterThan20AndDisease(@PathVariable("age")Integer age,@PathVariable("disease")String disease){
       List<Patient> patients=new ArrayList<>();
       for(Patient p: patientDb.values()){
           if(age<p.getAge() && p.getDisease().equals(disease)){
               patients.add(p);
           }
       }
       return patients;
    }



   @GetMapping("/getPatientInfo")
    public Patient getPatient(@RequestParam("patientId")Integer patientId){
       Patient patient=patientDb.get(patientId);
       return patient;
   }
   @GetMapping("/getAllPatients")
    public List<Patient> getAllPatients(){
       List<Patient> patients=new ArrayList<>();
       for (Patient p: patientDb.values()){
           patients.add(p);

       }
       return patients;
   }
   @GetMapping("/getByName")
    public Patient getPatientByName(@RequestParam("name")String name){
       for (Patient p:patientDb.values()) {
           if (p.getName().equals(name)) {
               return p;
           }
       }
           return null;
   }
   @GetMapping("/getListGreaterThanAge")
    public List<Patient> getPatientGreaterThanAge(@RequestParam("age")Integer age){
       List<Patient> patients=new ArrayList<>();
       for(Patient p:patientDb.values()){
           if (p.getAge()>age){
               patients.add(p);
           }
       }
       return patients;
   }
   @PutMapping("/updateDisease")
   public String updateDisease(@RequestParam("patientId")Integer patientId,@RequestParam("disease")String disease) {
       if (patientDb.containsKey(patientId)) {
           Patient patient = patientDb.get(patientId);
           patient.setDisease(disease);
           patientDb.put(patientId, patient);
           return "Update sucessfully disease";
       }else{
           return "patient doesn't exist";
       }
   }

   @PutMapping("/updateDetails")
    public String updatePatientDetails(@RequestBody Patient patient){
       int key=patient.getPatientId();
       if(patientDb.containsKey(key)){
           patientDb.put(key,patient);
           return "patient has successfully update";
       }else{
           return "Data was not existing";
       }
   }
@DeleteMapping("/delete")
    public String deletePatient(@RequestParam("patientId")Integer patientId){
       patientDb.remove(patientId);
       return "patient successfully delete";
}



}
