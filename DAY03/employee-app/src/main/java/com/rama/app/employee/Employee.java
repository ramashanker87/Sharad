package com.rama.app.employee;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Employee {
    String Name;
    int Age;
    String Company;
    String ID;
    Integer Salary;
    public Employee(String name, String ID, int age, String company, Integer salary) {
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
        List<Employee> emp =new ArrayList<>();
        emp.add(new Employee("Sharad","394",23,"TCS",32000));
        emp.add(new Employee("Ansh","423",21,"JIO",30000));
        emp.add(new Employee("Ajit","231",24,"ABC",18000));
        emp.add(new Employee("Kshitj","488",22,"XYZ",22000));
        List<Employee> HighSalary =emp.stream().filter(emp1 -> emp1.getSalary()>25000).collect(Collectors.toList());
        HighSalary.forEach(System.out::println);
        System.out.println(HighSalary);
        for (Employee emp1 : HighSalary) {
            System.out.println(emp1.getName());
            System.out.println(emp1.getSalary());
        }
        List<Employee> HighAge =emp.stream().filter(emp1 -> emp1.getAge()<30).collect(Collectors.toList());
        System.out.println("High Age");
        for (Employee emp1 : HighAge) {
            System.out.println(emp1.getName());
            System.out.println(emp1.getSalary());
        }
    }
}