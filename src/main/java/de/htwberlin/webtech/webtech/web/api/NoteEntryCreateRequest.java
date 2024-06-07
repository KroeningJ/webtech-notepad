package de.htwberlin.webtech.webtech.web.api;

public class NoteEntryCreateRequest {

    private String ldt;
    private String entry;
    private String colour;

    public NoteEntryCreateRequest() {}
    public NoteEntryCreateRequest(String ldt, String entry, String colour) {
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
