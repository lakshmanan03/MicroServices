package com.scgapps.mobile.api.calendar.rest;

import ch.qos.logback.classic.Logger;
import com.scgapps.mobile.api.calendar.model.CalendarEvent;
import com.scgapps.mobile.api.calendar.rest.client.ICalendarClient;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("/api/calendar")
@Api(value = "RPMPCG-CALENDAR-SERVICE")
public class CalendarController {

    private final Logger logger = (Logger) LoggerFactory.getLogger(CalendarController.class);
    private final ICalendarClient calendarClient;

    public CalendarController(ICalendarClient calendarClient){
        this.calendarClient = calendarClient;
    }

    /**
     * Get all the calendar events of the User, or events list based on Date range.
     * @param startDate -- Start Date for filter Calendar events
     * @param endDate -- End Date for filter Calendar events
     * @return -- List of Calendar events
     */
    @GetMapping("/events/instances")
    @ApiOperation(value = "fetch list of calendar events", response = CalendarEvent.class)
    public ResponseEntity<List<CalendarEvent>> getCalendarEvents(@RequestParam(required = false) Instant startDate, @RequestParam(required = false) Instant endDate) {
        logger.info("Calendar API Events");
        String userId = "2831";
        String companyName = "usl3";
        List<CalendarEvent> calendarEvens = calendarClient.getCalendarEvents(companyName, userId, startDate, endDate);
        return ResponseEntity.ok().body(calendarEvens);
    }
}
