package com.imanolortiz.ride.rides.infrastructure.db.repository;

import com.imanolortiz.ride.rides.infrastructure.db.entity.RideEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface RideJpaRepository extends JpaRepository<RideEntity, Long> {

    Optional<RideEntity> findById(Long id);

    @Query("SELECT r FROM rides r JOIN FETCH r.passenger WHERE r.passengerId = :passengerId")
    Page<RideEntity> findByPassengerId(@Param("passengerId") Long userId, Pageable pageable);
}
