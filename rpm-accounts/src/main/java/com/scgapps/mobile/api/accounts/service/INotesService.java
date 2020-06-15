package com.scgapps.mobile.api.accounts.service;

import com.scgapps.mobile.api.accounts.domain.Notes;
import com.scgapps.mobile.api.accounts.domain.NotesType;
import com.scgapps.mobile.api.accounts.model.NotesRequest;

import java.util.List;

public interface INotesService {
    List<NotesType> getNoteTypes();
    Notes createActivityNotes(NotesRequest notesRequest);
}
