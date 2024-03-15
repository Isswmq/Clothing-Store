package org.store.dev.moonrock.model.user;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "address")
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    @Size(min = 3, max = 20)
    private String country;

    @NotBlank
    @Size(min = 3, max = 20)
    private String city;

    @NotBlank
    @Size(min = 3, max = 20)
    private String street;

    @NotBlank
    @Size(min = 3, max = 20)
    private String house;

    @NotBlank
    @Size(min = 3, max = 20)
    private String postal_code;
}
