package github.com.evertonbrunosds.note.model.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "change_password", schema = "public")
public class ChangePasswordEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false, unique = true)
    private UUID id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userprofile_id", referencedColumnName = "id", updatable = false, nullable = false, unique = true)
    private UserprofileEntity userprofile;

    @Column(name = "activation_key", length = 192, nullable = false)
    private String activationKey;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

}
