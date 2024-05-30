package ru.javakira.workportalapi.vacancy;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
todo добавить ссылки на ресурсы, создать статический сервис
*/

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "vacancies")
public class Vacancy {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private long ownerId;
    @ManyToOne
    private VacancyCategory vacancyCategory;
    private String title;
    private String description;
    private String address;
}
