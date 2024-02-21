package github.com.evertonbrunosds.note.model.entity.id;

import java.io.Serializable;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Builder;
import lombok.EqualsAndHashCode;

@Builder
@EqualsAndHashCode
@Embeddable
public class RelationshipEntityId implements Serializable {

    @Column(name = "follower_id", nullable = false, updatable = false)
    private UUID followerId;

    @Column(name = "followed_id", nullable = false, updatable = false)
    private UUID followedId;

    @Deprecated
    public RelationshipEntityId() {
    }

    public RelationshipEntityId(final UUID followerId, final UUID followedId) {
        if (followerId.equals(followedId)) {
            throw new IllegalArgumentException();
        }
        this.followerId = followerId;
        this.followedId = followedId;
    }

}
