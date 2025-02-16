package com.sharad.app.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "student")
@Getter
@Setter
@NoArgsConstructor  // Required for Hibernate
@AllArgsConstructor
@ToString

public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    @Column(nullable = false)
    private String name;
    @Column(unique = true, nullable = false)
    private String schoolName;
    @Column(nullable = false)
    private int age;
    @Column(nullable = false)
    private String gender;
}
