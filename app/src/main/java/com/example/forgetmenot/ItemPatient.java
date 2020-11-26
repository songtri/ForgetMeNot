package com.example.forgetmenot;

public class ItemPatient {
    String id;
    String patientName;
    String gender;
    String age;
    String date;

    public ItemPatient() { }

    public ItemPatient(String id, String patientName, String gender, String age, String date) {
        this.id = id;
        this.patientName = patientName;
        this.gender = gender;
        this.age = age;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
