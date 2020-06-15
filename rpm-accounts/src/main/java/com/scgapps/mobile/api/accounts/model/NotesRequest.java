package com.scgapps.mobile.api.accounts.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class NotesRequest {
    private String subject;
    private String comments;
    private int primaryAccountId;
    private int projectId;
    private String notesType;
    private List<Long> contactIds;
}
