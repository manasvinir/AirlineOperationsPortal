package com.manasvinir.AirlineOperationsPortal.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;

@EntityListeners(AuditingEntityListener.class)
@Data
@NoArgsConstructor
@Entity
public class CrewAssignment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "flight_id")
    private Flight flight;

    @ManyToOne(optional = false)
    @JoinColumn(name = "crewmember_id")
    private CrewMember crewMember;

    @Enumerated(EnumType.STRING)
    private Role assignedRole;
    public enum Role {
        PILOT,
        COPILOT,
        PURSER,//cabin supervisor or manager, a senior flight attendant
        ATTENDANT
    }

    @CreatedDate
    private Instant assignedAt;

}
