package com.example.jpa_advanced;

import com.example.jpa_advanced.models.Author;
import com.example.jpa_advanced.models.specifications.AuthorSpecification;
import com.example.jpa_advanced.repositories.AuthorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;


@SpringBootApplication
public class JpaAdvancedApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaAdvancedApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(
            AuthorRepository authorRepository
    ) {
        return args -> {
            /*Faker faker = new Faker();
            for (int i = 0; i < 50; i++) {
                Author author = Author
                        .builder()
                        .firstName(faker.name().firstName())
                        .lastName(faker.name().lastName())
                        .email(faker.name().username()+ "@hotmail.com")
                        .age(faker.number().numberBetween(5, 80))
                        .build();

                authorRepository.save(author);
            }*/

            /*authorRepository.findByAge(60)
                    .forEach(System.out::println);

            System.out.println("**********");

            authorRepository.findByFirstOrLastName("Jacob","Murazik")
                    .forEach(System.out::println);*/

            Specification<Author> spec = Specification
                    .where(AuthorSpecification.firstNameLike("m"))
                    .and(AuthorSpecification.greaterThanAge(40));

            authorRepository.findAll(spec, Sort.by("age").ascending())
                    .forEach(System.out::println);

        };
    }
}
