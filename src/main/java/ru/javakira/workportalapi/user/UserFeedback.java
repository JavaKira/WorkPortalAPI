package ru.javakira.workportalapi.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user_feedbacks")
public class UserFeedback {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private long fromUserId;
    private long toUserId;
}
