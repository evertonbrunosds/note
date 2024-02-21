package github.com.evertonbrunosds.note.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import github.com.evertonbrunosds.note.model.entity.RelationshipEntity;
import github.com.evertonbrunosds.note.model.entity.id.RelationshipEntityId;

@Repository
public interface RelationshipRepository extends JpaRepository<RelationshipEntity, RelationshipEntityId> {

}
