package com.scgapps.mobile.api.accounts.service;

import com.scgapps.mobile.api.accounts.domain.Notes;
import com.scgapps.mobile.api.accounts.domain.NotesType;
import com.scgapps.mobile.api.accounts.domain.PrimaryKeySequence;
import com.scgapps.mobile.api.accounts.model.NotesRequest;
import com.scgapps.mobile.api.accounts.repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class NotesService implements INotesService {

    private static final Logger logger = LoggerFactory.getLogger(NotesService.class);

    @Value("${TEST_USER_ID}")
    private long testUserId;

    @Autowired
    private NotesRepository notesRepository;

    @Autowired
    private PrimaryKeyRepository primaryKeyRepository;

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private NotesTypeRepository notesTypeRepository;

    @Override
    @Transactional(readOnly = true)
    public List<NotesType> getNoteTypes() {
        return notesTypeRepository.findAll();
    }

    @Override
    @Transactional
    public Notes createActivityNotes(NotesRequest notesRequest) {
        logger.trace("Request to createAccountActivityNotes service");
        Notes notes = getNotesObj(notesRequest);

        Optional<PrimaryKeySequence> optionalPrimaryKeySequence = primaryKeyRepository.findById("NOTES");
        PrimaryKeySequence primaryKeySequence;
        if (optionalPrimaryKeySequence.isPresent()) {
            primaryKeySequence = optionalPrimaryKeySequence.get();
        } else {
            primaryKeySequence = new PrimaryKeySequence();
            primaryKeySequence.setNextValue(1);
            primaryKeySequence.setTableName("NOTES");
        }

        long notesId = primaryKeySequence.getNextValue();
        notes.setId(notesId);
        List<Long> contactIds = notesRequest.getContactIds();
        if (contactIds != null && !contactIds.isEmpty()) {
            notes.setContact(contactRepository.findAllById(contactIds));
        }
        Notes noteResponse = notesRepository.save(notes);
        primaryKeySequence.setNextValue(primaryKeySequence.getNextValue() + 1);
        primaryKeyRepository.save(primaryKeySequence);
        logger.trace("Exit from createAccountActivityNotes service");
        return noteResponse;
    }

    private Notes getNotesObj(NotesRequest notesRequest) {
        Notes notes = new Notes();
        notes.setUserId(testUserId);
        notes.setCreatedBy(testUserId);
        notes.setLastModifiedBy(testUserId);
        notes.setCreated(Instant.now());
        notes.setUpdateAccountTeam(0);
        notes.setUpdateProjectTeam(0);
        notes.setDeleted(0);
        notes.setLastModified(Instant.now());
        notes.setSubject(notesRequest.getSubject());
        notes.setComments(notesRequest.getComments());
        notes.setType(notesRequest.getNotesType());
        long accountId = notesRequest.getPrimaryAccountId();
        int projectId = notesRequest.getProjectId();
        if (accountId > 0) {
            notes.setPrimaryAccount(accountId);
        }
        if (projectId > 0) {
            notes.setProject(projectId);
        }

        return notes;
    }


}
