package de.htwberlin.webtech.webtech.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class NoteController {

    @GetMapping("/todos")
    public List<NoteEntry> greeting() {
        NoteEntry entry = new NoteEntry("Erledige Hausaufgaben", "Mathe und Englisch");
        NoteEntry entry1 = new NoteEntry("Einkauf erledigen", "Milch, Brot, Eier");
        NoteEntry entry2 = new NoteEntry("Sport machen", "Laufen im Park");
        NoteEntry entry3 = new NoteEntry("Arzttermin", "Um 15:30 Uhr bei Dr. Müller");
        NoteEntry entry4 = new NoteEntry("Geburtstagskarte schreiben", "Für Oma");
        return List.of(entry, entry1, entry2, entry3, entry4);
    }
}
