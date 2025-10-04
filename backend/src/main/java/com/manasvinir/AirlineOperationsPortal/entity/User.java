package com.manasvinir.AirlineOperationsPortal.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String passwordHash;    //encrypted with BCrypt

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;
    public enum Role {
        ADMIN,
        STAFF
    }

    @Column(unique = true, nullable = false)
    private String email;

    //Relationships
    //Reverse mapping, 1 User : M Flight as User can create and modify flights (only Admin!)
    @OneToMany(mappedBy = "createdBy")
    private List<Flight> createdFlights = new ArrayList<>();

    @OneToMany(mappedBy = "lastModifiedBy")
    private List<Flight> modifiedFlights = new ArrayList<>();
    //Relationships

    //chose Instant as it is time-zone independent, essential for tracking across timezones
    @CreatedDate
    @Column(nullable = false, updatable = false)
    private Instant createdAt;

    @LastModifiedDate
    private Instant updatedAt;


}
