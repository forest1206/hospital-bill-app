package com.mends4112.model;

/**
 *  Model for Patient
 */
public class Patient {
    private String patientName;
    private String patientAddress;
    private Integer patientAge;
    private String patientGender;

    public Patient(String name, String address, Integer age, String gender){
        this.setPatientName(name);
        this.setPatientAddress(address);
        this.setPatientAge(age);
        this.setPatientGender(gender);
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatientAddress() {
        return patientAddress;
    }

    public void setPatientAddress(String patientAddress) {
        this.patientAddress = patientAddress;
    }

    public Integer getPatientAge() {
        return patientAge;
    }

    public void setPatientAge(Integer patientAge) {
        this.patientAge = patientAge;
    }

    public String getPatientGender() {
        return patientGender;
    }

    public void setPatientGender(String patientGender) {
        this.patientGender = patientGender;
    }
}
