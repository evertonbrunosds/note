package github.com.evertonbrunosds.note.model.entity;

import static github.com.evertonbrunosds.note.util.LocalDateTimeManager.currentLocalDateTime;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import github.com.evertonbrunosds.note.setting.Constant;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Entity
@Table(name = "change_email", schema = Constant.Schema.current)
public class ChangeEmailEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false, unique = true)
    private UUID id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userprofile_id", referencedColumnName = "id", updatable = false, nullable = false, unique = true)
    private UserprofileEntity userprofile;

    @Setter
    @Column(name = "email", length = 256, nullable = false, unique = true)
    private String email;

    @Setter
    @Column(name = "activation_key", length = 192, nullable = false)
    private String activationKey;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Getter(AccessLevel.NONE)
    @OneToOne(mappedBy = "changeEmail", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private VerifyChangeEmailEntity verifyChangeEmail;

    @Deprecated
    public ChangeEmailEntity() {
    }

    public ChangeEmailEntity(final UserprofileEntity userprofile) {
        this.userprofile = userprofile;
        createdAt = currentLocalDateTime();
    }

    public Optional<VerifyChangeEmailEntity> getVerifyChangeEmail() {
        return Optional.ofNullable(this.verifyChangeEmail);
    }

}
