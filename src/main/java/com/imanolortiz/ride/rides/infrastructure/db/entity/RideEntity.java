package com.imanolortiz.ride.rides.infrastructure.db.entity;

import com.imanolortiz.ride.users.infrastructure.db.entity.UserEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.locationtech.jts.geom.Point;

import java.time.Instant;

@Table
@Entity(name = "rides")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RideEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "passenger_id", nullable = false, insertable = false, updatable = false)
    private Long passengerId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "passenger_id", nullable = false, foreignKey = @ForeignKey(name = "fk_rid_passenger"))
    private UserEntity passenger;

    @Column(columnDefinition = "geometry(Point,4326)")
    private Point passengerLocation;

    @Column(columnDefinition = "geometry(Point,4326)")
    private Point destinationLocation;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private Instant createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private Instant updatedAt;

    @Column(name = "deleted_at")
    private Instant deletedAt;


}
