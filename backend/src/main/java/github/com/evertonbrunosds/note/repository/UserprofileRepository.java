package github.com.evertonbrunosds.note.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import github.com.evertonbrunosds.note.model.entity.UserprofileEntity;

@Repository
public interface UserprofileRepository extends JpaRepository<UserprofileEntity, UUID> {

}
