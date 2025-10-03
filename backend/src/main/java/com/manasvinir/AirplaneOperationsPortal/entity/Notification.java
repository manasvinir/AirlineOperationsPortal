package com.manasvinir.AirplaneOperationsPortal.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;

@Data
@NoArgsConstructor
@Entity
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "flight_id")
    private Flight flight;

    private Status type;
    public enum Status {
        DELAY,
        CANCELLATION,
        UPDATE
    }

    private String message;

    @CreationTimestamp
    private Instant timestamp;

}
