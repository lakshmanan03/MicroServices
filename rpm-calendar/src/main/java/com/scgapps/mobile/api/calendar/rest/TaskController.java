package com.scgapps.mobile.api.calendar.rest;


import com.scgapps.mobile.api.calendar.model.Task;
import com.scgapps.mobile.api.calendar.model.TaskSummary;
import com.scgapps.mobile.api.calendar.service.ITaskService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.util.List;

@RestController
@RequestMapping("/api/calendar")
@Api(value = "RPM-TASK-SERVICE")
public class TaskController {

    private final ITaskService taskService;

    public TaskController(ITaskService taskService) {
        this.taskService = taskService;
    }

    /**
     * Task Summary of the provided account Id
     *
     * @param taskId -- Path parameter
     * @return -- Contact Summary with contacts, addresses and notes.
     */
    @GetMapping("/task/{taskId}")
    @ApiOperation(value = "fetch selected task details", response = Task.class)
    public ResponseEntity<Task> getTask(@PathVariable Long taskId) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setAmbiguityIgnored(true);
        com.scgapps.mobile.api.calendar.domain.Task entityTask = taskService.getTask(taskId);
        return ResponseEntity.ok().body(modelMapper.map(entityTask, Task.class));
    }

    /**
     * Task Summary of the provided account Id
     *
     * @param accountId -- Path parameter
     * @return -- Contact Summary with contacts, addresses and notes.
     */
    @GetMapping("/task/account/{accountId}")
    @ApiOperation(value = "fetch selected account task list", response = TaskSummary.class)
    public ResponseEntity<List<TaskSummary>> getAccountTask(@PathVariable Integer accountId) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setAmbiguityIgnored(true);
        List<com.scgapps.mobile.api.calendar.domain.Task> entityTask = taskService.getAccountTasks(accountId);
        Type listType = new TypeToken<List<TaskSummary>>() {
        }.getType();
        return ResponseEntity.ok().body(modelMapper.map(entityTask, listType));
    }


    @GetMapping("/task/project/{projectId}")
    @ApiOperation(value = "fetch selected project task list", response = TaskSummary.class)
    public ResponseEntity<List<TaskSummary>> getProjectTask(@PathVariable Integer projectId) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setAmbiguityIgnored(true);
        List<com.scgapps.mobile.api.calendar.domain.Task> entityTask = taskService.getProjectTasks(projectId);
        Type listType = new TypeToken<List<TaskSummary>>() {
        }.getType();
        return ResponseEntity.ok().body(modelMapper.map(entityTask, listType));
    }


    @GetMapping("/task/contact/{contactId}")
    @ApiOperation(value = "fetch selected contact task list", response = TaskSummary.class)
    public ResponseEntity<List<TaskSummary>> getContactTask(@PathVariable Long contactId) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setAmbiguityIgnored(true);
        List<com.scgapps.mobile.api.calendar.domain.Task> entityTask = taskService.getContactTasks(contactId);
        Type listType = new TypeToken<List<TaskSummary>>() {
        }.getType();
        return ResponseEntity.ok().body(modelMapper.map(entityTask, listType));

    }
}
