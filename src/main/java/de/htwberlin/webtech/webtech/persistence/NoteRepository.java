package de.htwberlin.webtech.webtech.persistence;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepository extends JpaRepository<NoteEntryEntity, Long> {

    //List<NoteEntryEntity> findAllById(Long id);

}
