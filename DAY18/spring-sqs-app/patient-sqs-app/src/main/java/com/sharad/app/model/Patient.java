package com.sharad.app.model;

public class Patient {
    private String name;
    private String id;
    private String hospitalName;
    private int age;
    private String gender;

    public Patient(){}
    public Patient(String name, String id, String hospitalName, int age, String gender) {
        super();
        this.name = name;
        this.id = id;
        this.hospitalName = hospitalName;
        this.age = age;
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}