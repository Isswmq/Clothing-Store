package org.store.dev.moonrock.model;

import com.fasterxml.jackson.databind.ser.Serializers;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.envers.Audited;
import org.hibernate.envers.RelationTargetAuditMode;
import org.springframework.lang.NonNull;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "users")
@Data
@Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
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
