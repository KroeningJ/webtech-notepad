package de.htwberlin.webtech.webtech.service;

import de.htwberlin.webtech.webtech.web.api.NoteEntryCreateRequest;
import de.htwberlin.webtech.webtech.web.api.NoteEntry;
import org.springframework.stereotype.Service;
import de.htwberlin.webtech.webtech.persistence.NoteEntryEntity;
import de.htwberlin.webtech.webtech.persistence.NoteRepository;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class NoteEntryService {

    private final NoteRepository noteRepository;

    public NoteEntryService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public List<NoteEntry> findAll() {

        List<NoteEntryEntity> notes = noteRepository.findAll();

        return notes.stream().map(this::transformEntity)
                .collect(Collectors.toList());
    }

    public NoteEntry findById(Long id){

        var noteEntryEntity = noteRepository.findById(id);

        return noteEntryEntity.isPresent()? transformEntity(noteEntryEntity.get()) : null;
    }

    public NoteEntry updateNoteEntry(Long id, NoteEntryCreateRequest request){
        var noteEntryEntityOptional = noteRepository.findById(id);
        if (noteEntryEntityOptional.isEmpty()) {

            return null;
        }

        var  noteEntryEntity = noteEntryEntityOptional.get();

        noteEntryEntity.setLdt(request.getLdt());
        noteEntryEntity.setEntry(request.getEntry());
        noteEntryEntity.setColour(request.getEntry());

        noteEntryEntity= noteRepository.save(noteEntryEntity);

        return transformEntity(noteEntryEntity);
    }

    public NoteEntry create(NoteEntryCreateRequest request) {

        var noteEntryEntity = new NoteEntryEntity(request.getLdt(), request.getEntry(), request.getColour());
        noteRepository.save(noteEntryEntity);
        return transformEntity(noteEntryEntity);
    }

    public boolean deleteById (Long id) {
        if (!noteRepository.existsById(id)){

            return false;
        }

        noteRepository.deleteById(id);
        return true;
    }

    public NoteEntry transformEntity(NoteEntryEntity entity) {
        return new NoteEntry(
                entity.getId(),
                entity.getLdt(),
                entity.getEntry(),
                entity.getColour()
        );
    }
}

