package com.mends4112.model;

/**
 * Model for hospital charge
 */
public class HospitalCharge {

    private Integer dayCharge = 500;
    private Integer days;
    private Integer medication;
    private Integer surgical;
    private Integer lab;
    private Integer rehabilitation;

    public HospitalCharge(Integer days, Integer medication, Integer surgical, Integer lab, Integer rehabilitation){
        this.setDays(days);
        this.setMedication(medication);
        this.setSurgical(surgical);
        this.setLab(lab);
        this.setRehabilitation(rehabilitation);
    }

    public Integer CalcStayCharges() {
        return this.dayCharge * this.days;
    }

    public Integer CalcMiscCharges() {
        return this.medication + this.surgical + this.lab + this.rehabilitation;
    }

    public Integer CalcTotalCharges() {
        return this.CalcMiscCharges() + this.CalcStayCharges();
    }


    public Integer getDayCharge() {
        return dayCharge;
    }

    public void setDayCharge(Integer dayCharge) {
        this.dayCharge = dayCharge;
    }

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    public Integer getMedication() {
        return medication;
    }

    public void setMedication(Integer medication) {
        this.medication = medication;
    }

    public Integer getSurgical() {
        return surgical;
    }

    public void setSurgical(Integer surgical) {
        this.surgical = surgical;
    }

    public Integer getLab() {
        return lab;
    }

    public void setLab(Integer lab) {
        this.lab = lab;
    }

    public Integer getRehabilitation() {
        return rehabilitation;
    }

    public void setRehabilitation(Integer rehabilitation) {
        this.rehabilitation = rehabilitation;
    }
}
