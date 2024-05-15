package com.example.springbootsample.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

@Getter
@Setter
@Entity
@Table(name = "tbl_user")
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private String id;

    @Column(name = "username", nullable = false, length = 100)
    private String username;

    @Column(name = "password", length = 200)
    private String password;

}