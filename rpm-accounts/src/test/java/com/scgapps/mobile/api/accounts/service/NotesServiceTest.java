package com.scgapps.mobile.api.accounts.service;

import com.scgapps.mobile.api.accounts.domain.Notes;
import com.scgapps.mobile.api.accounts.domain.NotesType;
import com.scgapps.mobile.api.accounts.domain.PrimaryKeySequence;
import com.scgapps.mobile.api.accounts.model.NotesRequest;
import com.scgapps.mobile.api.accounts.repository.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("test")
public class NotesServiceTest {

	@InjectMocks
	private NotesService notesService;

	@Mock
	private NotesTypeRepository notesTypeRepository;

	@Mock
	private ContactRepository contactRepository;

	@Mock
	private AccountRepository accountRepository;

	@Mock
	private NotesRepository notesRepository;

	@Mock
	private PrimaryKeyRepository primaryKeyRepository;

	@Test
	public void testNotesTypes() {		
		when(notesService.getNoteTypes()).thenReturn(getNoteTypes());
		List<NotesType> response = notesService.getNoteTypes();
		assertEquals(response.get(0).getName(), "test_note");
	}

	@Test
	public void testCreateActivityNotes() {
		PrimaryKeySequence primaryKeySequence = new PrimaryKeySequence();
		primaryKeySequence.setNextValue(2200);
		when(contactRepository.findAllById(Mockito.any())).thenReturn(new ArrayList<>());
		when(notesRepository.save(Mockito.any())).thenReturn(getNotes());
		when(primaryKeyRepository.findById("NOTES")).thenReturn(Optional.of(primaryKeySequence));
		Notes response = notesService.createActivityNotes(getNoteReq());
		assertNotNull(response);
		assertEquals(response.getPrimaryAccount(), 4500);
		assertEquals(response.getProject(), 451);
	}

	@Test
	public void testCreateActivityNotesPrimaryKeySeqNull() {
		when(contactRepository.findAllById(Mockito.any())).thenReturn(new ArrayList<>());
		when(notesRepository.save(Mockito.any())).thenReturn(getNotes());
		when(primaryKeyRepository.findById("NOTES")).thenReturn(Optional.empty());
		Notes response = notesService.createActivityNotes(getNoteReq());
		assertNotNull(response);
		assertEquals(response.getPrimaryAccount(), 4500);
		assertEquals(response.getProject(), 451);
	}
	
	private List<NotesType> getNoteTypes() {
		List<NotesType> types = new ArrayList<>();
		NotesType type = new NotesType();
		type.setName("test_note");
		types.add(type);
		return types;
	}

	private NotesRequest getNoteReq() {
		List<Long> contactIds = new ArrayList<Long>();
		contactIds.add(2522L);
		contactIds.add(2566L);
		NotesRequest noteReq = new NotesRequest();
		noteReq.setSubject("sample note");
		noteReq.setComments("test creation of notes");
		noteReq.setNotesType("4");
		noteReq.setPrimaryAccountId(4500);
		noteReq.setProjectId(451);
		noteReq.setContactIds(contactIds);
		return noteReq;
	}

	private Notes getNotes() {
		Notes notes = new Notes();
		notes.setUserId(50013426L);
		notes.setPrimaryAccount((long)4500);
		notes.setProject(451);
		notes.setCreatedBy(50013426L);
		notes.setLastModifiedBy(50013426L);
		notes.setCreated(Instant.now());
		notes.setLastModified(Instant.now());
		return notes;
	}

}
