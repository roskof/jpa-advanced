package com.example.jpa_advanced.models.embedded;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Address {
    private String streetName;
    private String houseNumber;
    private String zipCode;
}
