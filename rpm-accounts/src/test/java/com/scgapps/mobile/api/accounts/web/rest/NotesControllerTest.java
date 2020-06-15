package com.scgapps.mobile.api.accounts.web.rest;

import com.scgapps.mobile.api.accounts.domain.Contact;
import com.scgapps.mobile.api.accounts.domain.Notes;
import com.scgapps.mobile.api.accounts.domain.NotesType;
import com.scgapps.mobile.api.accounts.model.NoteTypes;
import com.scgapps.mobile.api.accounts.model.NotesRequest;
import com.scgapps.mobile.api.accounts.model.ContactSummary;
import com.scgapps.mobile.api.accounts.model.Note;
import com.scgapps.mobile.api.accounts.model.TaskSummary;
import com.scgapps.mobile.api.accounts.service.INotesService;
import com.scgapps.mobile.api.accounts.service.NotesService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("test")
public class NotesControllerTest {
    @InjectMocks
    private NotesController notesController;    

    @Mock
    private NotesService notesService;
    
    @Test
    public void testCreateActivityNotes() {
    	Notes notes = new Notes();
    	notes.setType("2");
    	notes.setId(2121L);
    	when(notesService.createActivityNotes(Mockito.any())).thenReturn(notes);
    	ResponseEntity<Note> response = notesController.createActivityNotes(new NotesRequest());
    	assertNotNull(response);
    	assertEquals(response.getBody().getId(), notes.getId().longValue());
    }

    @Test
    public void testGetNotesType() {
        List<NotesType> types = new ArrayList<>();
        NotesType type = new NotesType();
        type.setName("test");
        types.add(type);
        when(notesService.getNoteTypes()).thenReturn(types);
        ResponseEntity<List<NoteTypes>> notesTypes = notesController.getNotesTypes();
        assertNotNull(notesTypes);
        assertEquals(200, notesTypes.getStatusCode().value());
        assertEquals(notesTypes.getBody().get(0).getName(), types.get(0).getName());

    }
}
