package de.htwberlin.webtech.webtech.web;

import de.htwberlin.webtech.webtech.persistence.NoteRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import de.htwberlin.webtech.webtech.web.api.NoteEntry;
import de.htwberlin.webtech.webtech.web.api.NoteEntryCreateRequest;
import de.htwberlin.webtech.webtech.service.NoteEntryService;


import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;


@RestController
public class NoteEntryRestController {

    private final NoteEntryService noteEntryService;

    public NoteEntryRestController(NoteEntryService noteEntryService) {
        this.noteEntryService = noteEntryService;
    }

    // Alle Notizen anzeigen
    @GetMapping(path = "/api/v1/notes")
    public ResponseEntity<List<NoteEntry>> fetchNotes() {
        return ResponseEntity.ok(noteEntryService.findAll());
    }

    // Notiz nach ID suchen
    @GetMapping(path = "/api/v1/notes/{id}")
    public ResponseEntity<NoteEntry> fetchNoteById(@PathVariable Long id) {
        var noteEntry = noteEntryService.findById(id);
        return noteEntry != null ? ResponseEntity.ok(noteEntry) : ResponseEntity.notFound().build();
    }

    // Notiz nach ID aktualisieren
    @PutMapping(path = "/api/v1/notes/{id}")
    public ResponseEntity<NoteEntry> updateNoteEntry(@PathVariable Long id, @RequestBody NoteEntryCreateRequest request) {
        var noteEntry = noteEntryService.updateNoteEntry(id, request);
        return noteEntry != null ? ResponseEntity.ok(noteEntry) : ResponseEntity.notFound().build();
    }

    // Notiz nach ID löschen
    @DeleteMapping(path = "/api/v1/notes/{id}")
    public ResponseEntity<Void> deleteNoteEntry(@PathVariable Long id) {
        boolean successful = noteEntryService.deleteById(id);
        return successful? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

    // Notizen erstellen
    @PostMapping(path = "/api/v1/notes")
    public ResponseEntity<Void> createNoteEntry(@Valid @RequestBody NoteEntryCreateRequest request) throws URISyntaxException {
        var noteEntry = noteEntryService.create(request);
        URI uri = new URI("/api/v1/notes/" + noteEntry.getId());
        return ResponseEntity.created(uri).build();
    }

}
