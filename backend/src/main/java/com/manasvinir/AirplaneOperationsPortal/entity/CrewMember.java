package com.manasvinir.AirplaneOperationsPortal.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class CrewMember {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;    //surrogate key for internal use

    @Column(nullable = false)
    private String name;

    @Column(unique = true, nullable = false)
    private String employeeId;    //business key which is visible in UI

    @Enumerated(EnumType.STRING)
    private CrewRole role;
    public enum CrewRole {
        PILOT,
        COPILOT,
        PURSER,//cabin supervisor or manager, a senior flight attendant
        ATTENDANT
    }

    private String email;

    private String phone;

    //Relationships
    @OneToMany(mappedBy = "crewMember", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CrewAssignment> crewAssignments = new ArrayList<>();
    //Relationships
}
