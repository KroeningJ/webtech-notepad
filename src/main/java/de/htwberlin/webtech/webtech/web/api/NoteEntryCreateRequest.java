package de.htwberlin.webtech.webtech.web.api;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class NoteEntryCreateRequest {

    private String ldt;

    @NotBlank(message = "Entry is mandatory")
    private String entry;

    private String colour;


    public NoteEntryCreateRequest(String ldt, String entry, String colour) {
        this.ldt = ldt;
        this.entry = entry;
        this.colour = colour;
    }

}
