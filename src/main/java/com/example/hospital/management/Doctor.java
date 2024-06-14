package com.example.hospital.management;

public class Doctor {
    private String name;
    private String specialization;
    private int age;
    private String Degree;
private int doctorId;
    public String getName() {
        return name;
    }
    public Doctor(String name, String specialization, int age, String degree, int doctorId) {
        this.name = name;
        this.specialization = specialization;
        this.age = age;
        Degree = degree;
        this.doctorId = doctorId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDegree() {
        return Degree;
    }

    public void setDegree(String degree) {
        Degree = degree;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }


    }

