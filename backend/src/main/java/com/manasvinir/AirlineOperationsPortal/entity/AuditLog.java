package com.manasvinir.AirlineOperationsPortal.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;

@EntityListeners(AuditingEntityListener.class)
@Data
@NoArgsConstructor
@Entity
public class AuditLog {
    @Id
    @GeneratedValue
    private Long id; // Surrogate PK

    @Enumerated(EnumType.STRING)
    private AuditAction action;
    public enum AuditAction {
        CREATE,
        UPDATE,
        DELETE
    }

    @Column(nullable = false)
    private String entityName; // holds "Flight", "CrewMember"

    @Column(nullable = false)
    private long entityId;     // holds flight.id or crewMember.id

    @Lob
    private String oldValue;   // JSON snapshot of previous state (nullable on CREATE)

    @Lob
    private String newValue;   // JSON snapshot of new state (nullable on DELETE)

    @ManyToOne
    @JoinColumn
    private String changedBy;  // username or employeeId of user making change

    @Column(nullable = false)
    private Instant changedAt; // UTC timestamp
}