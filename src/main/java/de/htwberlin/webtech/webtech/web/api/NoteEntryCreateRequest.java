package de.htwberlin.webtech.webtech.web.api;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class NoteEntryCreateRequest {

    private String ldt;
    private String entry;
    private String colour;


    public NoteEntryCreateRequest(String ldt, String entry, String colour) {
        this.ldt = ldt;
        this.entry = entry;
        this.colour = colour;
    }

}
