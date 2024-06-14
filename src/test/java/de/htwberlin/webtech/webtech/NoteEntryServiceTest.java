package de.htwberlin.webtech.webtech;

import de.htwberlin.webtech.webtech.web.api.NoteEntry;
import de.htwberlin.webtech.webtech.service.NoteEntryService;
import de.htwberlin.webtech.webtech.persistence.NoteEntryEntity;
import de.htwberlin.webtech.webtech.persistence.NoteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import de.htwberlin.webtech.webtech.web.api.NoteEntry;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class NoteEntryServiceTest {

    @InjectMocks
    private NoteEntryService noteEntryService;

    @Mock
    private NoteRepository noteRepository;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void findAllTest() {
        NoteEntryEntity note1 = new NoteEntryEntity("2022-01-01T00:00:00", "Note 1", "Red");
        NoteEntryEntity note2 = new NoteEntryEntity("2022-01-02T00:00:00", "Note 2", "Blue");

        when(noteRepository.findAll()).thenReturn(Arrays.asList(note1, note2));

        List<NoteEntry> notes = noteEntryService.findAll();

        assertEquals(2, notes.size());
        assertEquals(note1.getEntry(), notes.get(0).getEntry());
        assertEquals(note2.getEntry(), notes.get(1).getEntry());
    }
}
