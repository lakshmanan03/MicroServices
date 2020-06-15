package com.scgapps.mobile.api.calendar.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Attendees {
    private String emailAddress;
    private String type;
    private String responseStatus;
}
