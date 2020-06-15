package com.scgapps.mobile.api.accounts.web.client;

import com.scgapps.mobile.api.accounts.model.TaskSummary;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "rpm-gateway")
public interface TasksClient {

    @GetMapping(value = "/calendarservice/api/calendar/task/account/{accountId}")
    ResponseEntity<List<TaskSummary>> getAccountTask(@PathVariable Integer accountId);

    @GetMapping(value = "/calendarservice/api/calendar/task/contact/{contactId}")
    ResponseEntity<List<TaskSummary>> getContactTask(@PathVariable Long contactId);
}