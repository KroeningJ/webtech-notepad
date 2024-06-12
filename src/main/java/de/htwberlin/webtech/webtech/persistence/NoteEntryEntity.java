package de.htwberlin.webtech.webtech.persistence;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
}
