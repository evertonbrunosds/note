package github.com.evertonbrunosds.note.model.entity;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Entity
@Table(name = "kind", schema = Constant.Schema.current)
public class KindEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false, unique = true)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userprofile_id", referencedColumnName = "id", updatable = false, nullable = false)
    private UserprofileEntity userprofile;

    @Setter
    @Column(name = "name", length = 32, nullable = false)
    private String name;

    @Setter
    @Column(name = "hidden", nullable = false)
    private Boolean hidden;

    @OneToMany(mappedBy = "kind", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<NoteEntity> notes = new LinkedList<>();

    @Deprecated
    public KindEntity() {
    }

    public KindEntity(final UserprofileEntity userprofile, final Boolean hidden) {
        this.userprofile = userprofile;
        this.hidden = hidden;
    }

}
