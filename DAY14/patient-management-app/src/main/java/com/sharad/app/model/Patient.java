package com.sharad.app.model;

public class Patient {

    String name;
    String id;
    String hospitalName;
    int age;
    String gender;

    public Patient() {}
    public Patient(String name, String id, String hospitalName, int age, String gender) {
        super();
        this.name = name;
        this.id = id;
        this.hospitalName = hospitalName;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }


    public String getId() {
        return id;
    }


    public String getHospitalName() {
        return hospitalName;
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }



    @Override
    public String toString() {
        return "Patient{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", hospitalName='" + hospitalName + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }

}