package com.scgapps.mobile.api.calendar.model;

import org.springframework.validation.annotation.Validated;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Validated
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CalendarEvent {
    private List<Attendees> attendees;
    private String bodyContent;
    private String bodyContentType;
    private String endTimestamp;
    private String endTimeZone;
    private String id;
    private String locationDisplayName;
    private boolean sensitivityPrivate;
    private String startTimestamp;
    private String startTimeZone;
    private String subject;
    private String type;
    private String webLink;
}
