package com.example.jpa_advanced.models.embedded;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders")
@Builder
public class Order {
    @EmbeddedId
    private OrderId id;
    private String orderInfo;
    private String anotherField;

    @Embedded
    private Address address;
}
