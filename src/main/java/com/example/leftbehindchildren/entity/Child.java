package com.example.leftbehindchildren.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "children")
@Data
@NoArgsConstructor
public class Child {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private LocalDate birthDate;

    @Column(nullable = false)
    private String gender;

    private String schoolName;
    private String grade;

    @Column(nullable = false)
    private String guardianName;

    @Column(nullable = false)
    private String guardianPhone;

    private String guardianRelationship;

    @Column(nullable = false)
    private String currentAddress;

    private String parentsWorkplace;
    private String parentsContact;

    @Column(columnDefinition = "TEXT")
    private String healthCondition;

    @Column(columnDefinition = "TEXT")
    private String specialNeeds;

    @Column(columnDefinition = "TEXT")
    private String remarks;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "assigned_user_id")
    private User assignedUser;

    private LocalDate lastVisitDate;
    private LocalDate nextVisitDate;
}