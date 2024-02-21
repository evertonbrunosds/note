package github.com.evertonbrunosds.note.model.entity;

import static github.com.evertonbrunosds.note.util.LocalDateTimeManager.currentLocalDateTime;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import github.com.evertonbrunosds.note.setting.Constant;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Entity
@Table(name = "note", schema = Constant.Schema.current)
public class NoteEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false, unique = true)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "kind_id", referencedColumnName = "id", updatable = false, nullable = false)
    private KindEntity kind;

    @Setter
    @Column(name = "title", length = 32, nullable = false)
    private String title;

    @Setter
    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Deprecated
    public NoteEntity() {
    }

    public NoteEntity(final KindEntity kind) {
        this.kind = kind;
        createdAt = currentLocalDateTime();
    }

}
