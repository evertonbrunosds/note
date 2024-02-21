package github.com.evertonbrunosds.note.model.entity;

import static github.com.evertonbrunosds.note.util.LocalDateTimeManager.currentLocalDateTime;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import github.com.evertonbrunosds.note.model.RelationshipState;
import github.com.evertonbrunosds.note.model.entity.id.RelationshipEntityId;
import github.com.evertonbrunosds.note.setting.Constant;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Entity
@Table(name = "relationship", schema = Constant.Schema.current)
public class RelationshipEntity implements Serializable {

    @EmbeddedId
    private RelationshipEntityId id;

    @MapsId("followerId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "follower_id", insertable = false, updatable = false, nullable = false)
    private UserprofileEntity follower;

    @MapsId("followedId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "followed_id", insertable = false, updatable = false, nullable = false)
    private UserprofileEntity followed;

    @Setter
    @JdbcTypeCode(SqlTypes.NAMED_ENUM)
    @Column(name = "state", columnDefinition = "relationship_state", nullable = false)
    private RelationshipState state;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Deprecated
    public RelationshipEntity() {
    }

    public RelationshipEntity(final UserprofileEntity follower, final UserprofileEntity followed) {
        final var builderId = RelationshipEntityId.builder();
        builderId.followerId(follower.getId()).followedId(followed.getId());
        id = builderId.build();
        this.follower = follower;
        this.followed = followed;
        state = RelationshipState.PENDING;
        createdAt = currentLocalDateTime();
    }

}
