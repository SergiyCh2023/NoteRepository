package com.example.Note.feature.user;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Table(name = "users")
@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String password;
    private String role;


}
