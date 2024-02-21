package github.com.evertonbrunosds.note.model.entity;

import static github.com.evertonbrunosds.note.util.LocalDateTimeManager.currentLocalDateTime;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
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
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Entity
@Table(name = "userprofile", schema = Constant.Schema.current)
public class UserprofileEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false, unique = true)
    private UUID id;

    @Setter
    @Column(name = "username", length = 64, nullable = false, unique = true)
    private String username;

    @Setter
    @Column(name = "email", length = 256, nullable = false, unique = true)
    private String email;

    @Setter
    @Column(name = "caption", length = 32, nullable = false)
    private String caption;

    @Setter
    @Column(name = "description", columnDefinition = "text")
    private String description;

    @Setter
    @Column(name = "birthday", nullable = false)
    private LocalDate birthday;

    @Setter
    @Column(name = "password", length = 60, nullable = false)
    private String password;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Getter(AccessLevel.NONE)
    @OneToOne(mappedBy = "userprofile", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private VerifyEmailEntity verifyEmail;

    @Getter(AccessLevel.NONE)
    @OneToOne(mappedBy = "userprofile", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private ChangePasswordEntity changePassword;

    @Getter(AccessLevel.NONE)
    @OneToOne(mappedBy = "userprofile", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private ChangeEmailEntity changeEmail;

    @OneToMany(mappedBy = "userprofile", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<KindEntity> kinds = new LinkedList<>();

    @OneToMany(mappedBy = "follower", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<RelationshipEntity> relationshipsMadeByMe = new LinkedList<>();

    @OneToMany(mappedBy = "followed", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<RelationshipEntity> relationshipsMadeBySomeone = new LinkedList<>();

    public UserprofileEntity() {
        createdAt = currentLocalDateTime();
    }

    public Optional<VerifyEmailEntity> getVerifyEmail() {
        return Optional.ofNullable(this.verifyEmail);
    }

    public Optional<ChangePasswordEntity> getChangePassword() {
        return Optional.ofNullable(this.changePassword);
    }

    public Optional<ChangeEmailEntity> getChangeEmail() {
        return Optional.ofNullable(this.changeEmail);
    }

}
