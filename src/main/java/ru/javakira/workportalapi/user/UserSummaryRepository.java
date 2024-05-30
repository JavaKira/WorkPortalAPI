package ru.javakira.workportalapi.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserSummaryRepository extends JpaRepository<UserSummary, Long> {
}
