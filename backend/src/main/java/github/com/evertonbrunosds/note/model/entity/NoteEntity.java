package github.com.evertonbrunosds.note.model.entity;

import static github.com.evertonbrunosds.note.util.LocalDateTimeManager.currentLocalDateTime;

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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Data
@Entity
@Table(name = "note", schema = Constant.Schema.current)
public class NoteEntity implements Serializable {

    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false, unique = true)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "kind_id", referencedColumnName = "id", updatable = false, nullable = false)
    private KindEntity kind;

    @Column(name = "title", length = 32, nullable = false)
    private String title;

    @Column(name = "content", nullable = false)
    private String content;

    @Setter(AccessLevel.NONE)
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    public NoteEntity() {
        createdAt = currentLocalDateTime();
    }

}
