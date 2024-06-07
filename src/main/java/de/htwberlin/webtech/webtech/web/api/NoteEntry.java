package de.htwberlin.webtech.webtech.web.api;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;
import lombok.Getter;
import lombok.Setter;

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

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLdt() {
        return ldt;
    }

    public void setLdt(String ldt) {
        this.ldt = ldt;
    }

    public String getEntry() {
        return entry;
    }

    public void setEntry(String entry) {
        this.entry = entry;
    }
}


