package com.rama.app.employee;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EmployeeMap {
    String Name;
    int Age;
    String Company;
    String ID;
    Integer Salary;
    public EmployeeMap(String name, String ID, int age, String company, Integer salary) {
        this.Name = name;
        this.Age = age;
        this.Company = company;
        this.ID = ID;
        this.Salary = salary;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public String getCompany() {
        return Company;
    }

    public void setCompany(String company) {
        Company = company;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public Integer getSalary() {
        return Salary;
    }

    public void setSalary(Integer salary) {
        Salary = salary;
    }

    public static void main(String[] args) {
        List<EmployeeMap> emp =new ArrayList<>();
        emp.add(new EmployeeMap("Sharad","394",23,"TCS",32000));
        emp.add(new EmployeeMap("Ansh","423",21,"JIO",30000));
        emp.add(new EmployeeMap("Ajit","231",24,"ABC",18000));
        emp.add(new EmployeeMap("Kshitj","488",22,"XYZ",22000));

        Map<String,Integer> FilterSalary = emp.stream().filter(emp1 -> emp1.getSalary()<40000).collect(Collectors.toMap(EmployeeMap::getName, EmployeeMap::getSalary));

        System.out.println(FilterSalary);
        Map<String,Integer> FilterAge = emp.stream().filter(emp1 -> emp1.getAge()>25).collect(Collectors.toMap(EmployeeMap::getName, EmployeeMap::getAge));
        System.out.println(FilterAge);
    }
}