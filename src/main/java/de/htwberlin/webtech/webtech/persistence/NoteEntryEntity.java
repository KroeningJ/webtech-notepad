package de.htwberlin.webtech.webtech.persistence;

import javax.persistence.*;
import java.time.LocalDateTime;



@Entity(name = "Notes")
public class NoteEntryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "EntryTime", nullable = false)
    private String ldt = LocalDateTime.now().toString();

    @Column(name = "Entry", nullable = false)
    private String entry;

    @Column(name= "Color", nullable = false)
    private String colour;

    public NoteEntryEntity(String ldt, String entry, String colour) {
        this.ldt = ldt;
        this.entry = entry;
        this.colour = colour;
    }

    public NoteEntryEntity() {

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