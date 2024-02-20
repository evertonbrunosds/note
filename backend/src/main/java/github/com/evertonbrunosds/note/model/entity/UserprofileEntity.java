package github.com.evertonbrunosds.note.model.entity;

import static github.com.evertonbrunosds.note.util.LocalDateTimeManager.currentLocalDateTime;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

import org.aspectj.asm.internal.Relationship;

import github.com.evertonbrunosds.note.util.Constant;
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
import lombok.Data;
import lombok.Setter;

@Data
@Entity
@Table(name = "userprofile", schema = Constant.Schema.current)
public class UserprofileEntity implements Serializable {

    @Setter(AccessLevel.NONE)
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

    @Setter(AccessLevel.NONE)
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Setter(AccessLevel.NONE)
    @OneToOne(mappedBy = "userprofile", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private VerifyEmailEntity verifyEmail;

    @Setter(AccessLevel.NONE)
    @OneToOne(mappedBy = "userprofile", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private ChangePasswordEntity changePassword;

    @Setter(AccessLevel.NONE)
    @OneToOne(mappedBy = "userprofile", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private ChangeEmailEntity changeEmail;

    @Setter(AccessLevel.NONE)
    @OneToMany(mappedBy = "userprofile", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<KindEntity> kinds = new LinkedList<>();

    @Setter(AccessLevel.NONE)
    @OneToMany(mappedBy = "follower", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<Relationship> followerList = new LinkedList<>();

    @Setter(AccessLevel.NONE)
    @OneToMany(mappedBy = "followed", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<Relationship> followedList = new LinkedList<>();

    public UserprofileEntity() {
        createdAt = currentLocalDateTime();
    }

}
