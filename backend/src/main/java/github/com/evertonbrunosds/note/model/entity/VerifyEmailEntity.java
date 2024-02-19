package github.com.evertonbrunosds.note.model.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import github.com.evertonbrunosds.note.util.Constant;
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
@Table(name = "verify_email", schema = Constant.Schema.current)
public class VerifyEmailEntity implements Serializable {

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
