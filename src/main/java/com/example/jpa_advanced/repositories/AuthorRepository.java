package com.example.jpa_advanced.repositories;

import com.example.jpa_advanced.models.Author;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Integer>, JpaSpecificationExecutor<Author> {
    List<Author> findAllByFirstNameContainingIgnoreCase(String name);

    List<Author> findAllByFirstNameStartsWithIgnoreCase(String name);

    List<Author> findAllByFirstNameInIgnoreCase(List<String> firstNameList);

    @Modifying
    @Transactional
    @Query("update Author a set a.age=:age where a.id=:id")
    int updateAuthor(int age, int id);

    @Modifying
    @Transactional
    @Query("update Author a set a.age=:age")
    int updateAllAuthors(int age);

    List<Author> findByAge(@Param("age") int age);

    List<Author> findByFirstOrLastName(@Param("firstName") String firstName,
                                       @Param("lastName") String lastName);
}
