package com.example.springbootsample.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "message")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "key", length = Integer.MAX_VALUE)
    private String key;

    @Column(name = "value", length = Integer.MAX_VALUE)
    private String value;

    @Size(max = 100)
    @Column(name = "user_created", length = 100)
    private String userCreated;

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @Size(max = 100)
    @Column(name = "user_updated", length = 100)
    private String userUpdated;

    @Column(name = "updated_date")
    private LocalDateTime updatedDate;

}