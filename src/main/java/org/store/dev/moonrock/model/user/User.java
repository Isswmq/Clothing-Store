package org.store.dev.moonrock.model.user;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.envers.Audited;
import org.hibernate.envers.RelationTargetAuditMode;

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

    @NotBlank(message = "Username is required")
    @Column(unique = true, nullable = false)
    private String email;

    @NotBlank(message = "Password is required")
    @Size(min = 8, message = "Password must be longer than 8 characters")
    private char[] password;

    @NotBlank(message = "Firstname is required")
    @Column(name = "first_name")
    private String firstname;

    @NotBlank(message = "Lastname is required")
    @Column(name = "last_name")
    private String lastname;

    @OneToOne(cascade = CascadeType.ALL)
    @NotBlank(message = "Address is required")
    @JoinColumn(name = "address", referencedColumnName = "id")
    private Address address;

    @NotBlank(message = "Phone is required")
    private Integer phone;
}
