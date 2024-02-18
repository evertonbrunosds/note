package github.com.evertonbrunosds.note.model.entity;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "kind", schema = "public")
public class KindEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false, unique = true)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userprofile_id", referencedColumnName = "id", updatable = false, nullable = false)
    private UserprofileEntity userprofile;

    @Column(name = "name", length = 32, nullable = false)
    private String name;

    @OneToMany(mappedBy = "kind", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<NoteEntity> notes = new LinkedList<>();

}
