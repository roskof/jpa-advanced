package com.example.jpa_advanced.models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@NamedQueries({
        @NamedQuery(
                name = "Author.findByAge",
                query = "select a from Author a where a.age >= :age"
        ),
        @NamedQuery(
                name = "Author.findByFirstOrLastName",
                query = "select a from Author a where a.firstName = :firstName or a.lastName = :lastName"
        )
})
public class Author extends BaseEntity {

    @Column(
            name = "f_name",
            length = 35
    )
    private String firstName;
    private String lastName;

    @Column(
            unique = true,
            nullable = false
    )
    private String email;

    private int age;

    @ToString.Exclude
    @ManyToMany(mappedBy = "authors")
    private List<Course> courses;
}
