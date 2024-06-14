package de.htwberlin.webtech.webtech;

import de.htwberlin.webtech.webtech.service.NoteEntryService;
import de.htwberlin.webtech.webtech.web.NoteEntryRestController;
import de.htwberlin.webtech.webtech.web.api.NoteEntry;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Arrays;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.hamcrest.Matchers.*;

@WebMvcTest(NoteEntryRestController.class)
public class NoteEntryRestControllerTest {

    private MockMvc mockMvc;

    @MockBean
    private NoteEntryService noteEntryService;

    @BeforeEach
    public void setup(WebApplicationContext wac) {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void fetchNotesTest() throws Exception {
        NoteEntry note1 = new NoteEntry(1L, "2022-01-01T00:00:00", "Note 1", "Red");
        NoteEntry note2 = new NoteEntry(2L, "2022-01-02T00:00:00", "Note 2", "Blue");

        when(noteEntryService.findAll()).thenReturn(Arrays.asList(note1, note2));

        mockMvc.perform(get("/api/v1/notes")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].entry", is("Note 1")))
                .andExpect(jsonPath("$[0].colour", is("Red")))
                .andExpect(jsonPath("$[1].id", is(2)))
                .andExpect(jsonPath("$[1].entry", is("Note 2")))
                .andExpect(jsonPath("$[1].colour", is("Blue")));
    }
}
