package com.imanolortiz.ride.users.infrastructure.db.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Table
@Entity(name = "users")
@Getter
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "email")
    private String email;

    @Column(name = "password_hash")
    private String passwordHash;

}
