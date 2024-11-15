package com.example.jpa_advanced.models.specifications;

import com.example.jpa_advanced.models.Author;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.lang.Nullable;

public class AuthorSpecification {
    public static Specification<Author> hasAge(int age) {
        return (
                Root<Author> root,
                CriteriaQuery<?> query,
                CriteriaBuilder criteriaBuilder
        ) -> criteriaBuilder.equal(root.get("age"), age);
    }

    public static Specification<Author> firstNameLike(String firstName) {
        return (
                Root<Author> root,
                CriteriaQuery<?> query,
                CriteriaBuilder criteriaBuilder
        ) -> criteriaBuilder.like(criteriaBuilder.lower(root.get("firstName")),
                "%" + firstName.toLowerCase() + "%");
    }

    public static Specification<Author> greaterThanAge(int age) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.gt(root.get("age"), age);
    }
}
