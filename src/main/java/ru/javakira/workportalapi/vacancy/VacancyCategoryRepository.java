package ru.javakira.workportalapi.vacancy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VacancyCategoryRepository extends JpaRepository<VacancyCategory, String> {
}
