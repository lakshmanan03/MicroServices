package com.scgapps.mobile.api.calendar.rest;

import com.scgapps.mobile.api.calendar.model.CalendarEvent;
import com.scgapps.mobile.api.calendar.rest.client.ICalendarClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
public class CalendarControllerTest {

    @InjectMocks
    private CalendarController calendarController;
    @Mock
    private ICalendarClient calendarClient;

    @Test
    public void testGetCalendarEvents() {
        Instant startDate = Instant.parse("2019-01-21T05:47:26.853Z");
        Instant endDate = Instant.parse("2019-07-21T05:47:26.853Z");
        String userId = "2831";
        String companyName = "usl3";
        List<CalendarEvent> calendarEvents1 = new ArrayList<>();
        CalendarEvent calendarEvent = new CalendarEvent();
        calendarEvents1.add(calendarEvent);
        when(calendarClient.getCalendarEvents(companyName, userId, startDate, endDate)).thenReturn(calendarEvents1);
        ResponseEntity<List<CalendarEvent>> calendarEvents = calendarController.getCalendarEvents(startDate,endDate);
        assertNotNull(calendarEvents.getBody());
        assertEquals(calendarEvents1,calendarEvents.getBody());
    }
}
