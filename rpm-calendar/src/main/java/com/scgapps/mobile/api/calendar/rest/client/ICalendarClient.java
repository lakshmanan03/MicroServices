package com.scgapps.mobile.api.calendar.rest.client;

import com.scgapps.mobile.api.calendar.model.CalendarEvent;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.Instant;
import java.util.List;

@FeignClient(name = "CalendarClient", url = "${calendar.uri}")
public interface ICalendarClient {
    /**
     * Fetch the Calendar instances for a given date range.
     * @param companyName - User Company Name
     * @param userId - Logged in User
     * @param start - Start Date
     * @param end - End Date
     * @return - List of calendar instances
     */
    @GetMapping(value="${calendar.instances.url}")
    List<CalendarEvent> getCalendarEvents(
            @PathVariable("companyName") String companyName,
            @PathVariable("userId") String userId,
            @RequestParam(required = false) Instant start,
            @RequestParam(required=false) Instant end);
}
