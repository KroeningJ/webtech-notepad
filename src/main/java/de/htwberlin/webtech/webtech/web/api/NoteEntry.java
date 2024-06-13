package de.htwberlin.webtech.webtech.web.api;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class NoteEntry {

    private Long id;
    private String ldt;
    private String entry;
    private String colour;

    public NoteEntry(Long id,String ldt, String entry, String colour) {
        this.id = id;
        this.ldt = ldt;
        this.entry = entry;
        this.colour = colour;
    }

}


