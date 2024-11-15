package com.example.jpa_advanced.models.embedded;

import jakarta.persistence.Embeddable;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class OrderId {
    private String userName;

    @CreationTimestamp
    private LocalDateTime orderDate;
}
