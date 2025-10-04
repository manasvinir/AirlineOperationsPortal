package com.manasvinir.AirlineOperationsPortal.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;


@EntityListeners(AuditingEntityListener.class)
@Data
@NoArgsConstructor
@Entity
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String flightNumber;

    //will hold IATA code
    @Column(nullable = false, length = 3)
    private String origin;

    //will hold IATA code
    @Column(nullable = false, length = 3)
    private String destination;

    //depending on how ZDT shoes up on postgresql, may need annotations
    @Column(nullable = false)
    private ZonedDateTime departureTime;

    @Column(nullable = false)
    private ZonedDateTime arrivalTime;

    @Enumerated(EnumType.STRING)
    private Status status;
    public enum Status {
        SCHEDULED,
        DELAYED,
        CANCELLED,
        TAKEOFF
    }

    private String aircraftType;

    //Relationships
    @ManyToOne(optional = false)
    @JoinColumn(nullable = false)
    private User createdBy;

    @ManyToOne
    @JoinColumn
    private User modifiedBy;

    @OneToMany(mappedBy = "flight", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Notification> notifications = new ArrayList<>();

    @OneToMany(mappedBy = "flight", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CrewAssignment> crewAssignments = new ArrayList<>();
    //Relationships

    //chose Instant as it is time-zone independent, essential for tracking across timezones
    @CreatedDate
    @Column(nullable = false, updatable = false)
    private Instant createdAt;

    @LastModifiedDate
    private Instant updatedAt;
}
