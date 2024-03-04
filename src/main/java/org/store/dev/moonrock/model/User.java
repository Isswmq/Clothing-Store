package org.store.dev.moonrock.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.lang.NonNull;

import java.time.LocalDate;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    private String firstname;

    private String lastname;

    @Column(unique = true, nullable = false)
    private String email;

    private String address;

    private LocalDate birthDate;

    @Enumerated(EnumType.STRING)
    private Role role;
}
