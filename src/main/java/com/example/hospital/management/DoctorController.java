package com.example.hospital.management;

import java.util.*;
//package com.example.hospital.management;

import com.example.hospital.management.Doctor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/doctor")
public class DoctorController{
    HashMap<Integer, Doctor> doctorDb=new HashMap<>();
    @PostMapping("/addDoctor")
    public String addDoctor(@RequestBody Doctor doctor){
     int key=doctor.getDoctorId();
     int doctorId= doctor.getDoctorId();
     doctorDb.put(doctorId,doctor);

        return "Doctor has successfully Added";

    }
}
