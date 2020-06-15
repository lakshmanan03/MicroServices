package com.scgapps.mobile.api.accounts.web.rest;

import com.scgapps.mobile.api.accounts.domain.Notes;
import com.scgapps.mobile.api.accounts.domain.NotesType;
import com.scgapps.mobile.api.accounts.model.Note;
import com.scgapps.mobile.api.accounts.model.NoteTypes;
import com.scgapps.mobile.api.accounts.model.NotesRequest;
import com.scgapps.mobile.api.accounts.service.NotesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/accounts")
@Api(value = "RPM_NOTES_SERVICE")
public class NotesController {

    @Autowired
    private NotesService notesService;

    @PostMapping("/createNotes")
    public ResponseEntity<Note> createActivityNotes(@RequestBody NotesRequest notesRequest) {
        Notes notes = notesService.createActivityNotes(notesRequest);
        ModelMapper modelMapper = new ModelMapper();
        return new ResponseEntity<>(modelMapper.map(notes, Note.class), HttpStatus.CREATED);
    }


    @GetMapping("/notesTypes")
    @ApiOperation(value = "Get Note Types", response = List.class)
    public ResponseEntity<List<NoteTypes>> getNotesTypes() {
        ModelMapper modelMapper = new ModelMapper();
        Type listType = new TypeToken<List<NoteTypes>>() {
        }.getType();
        List<NotesType> result = notesService.getNoteTypes();
        List<NoteTypes> noteTypesList = new ArrayList<>();
        if (!result.isEmpty()) {
            noteTypesList = modelMapper.map(result, listType);
        }
        return ResponseEntity.ok().body(noteTypesList);
    }
}
