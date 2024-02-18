package github.com.evertonbrunosds.note.model.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "userprofile", schema = "public")
public class UserprofileEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false, unique = true)
    private UUID id;

    @Column(name = "username", length = 64, nullable = false, unique = true)
    private String username;

    @Column(name = "email", length = 256, nullable = false, unique = true)
    private String email;

    @Column(name = "caption", length = 32, nullable = false)
    private String caption;

    @Column(name = "description", columnDefinition = "text")
    private String description;

    @Column(name = "birthday", nullable = false)
    private LocalDate birthday;

    @Column(name = "password", length = 60, nullable = false)
    private String password;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

}
