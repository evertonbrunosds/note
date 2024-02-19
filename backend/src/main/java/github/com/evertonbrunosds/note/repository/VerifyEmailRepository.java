package github.com.evertonbrunosds.note.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import github.com.evertonbrunosds.note.model.entity.VerifyEmailEntity;

@Repository
public interface VerifyEmailRepository extends JpaRepository<VerifyEmailEntity, UUID> {

}
