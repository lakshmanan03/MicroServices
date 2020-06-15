package com.scgapps.mobile.api.calendar.rest;


import com.scgapps.mobile.api.calendar.domain.Task;
import com.scgapps.mobile.api.calendar.service.ITaskService;
import com.scgapps.mobile.api.calendar.model.TaskSummary;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
public class TaskControllerTest {


    @InjectMocks
    private TaskController taskController;

    @Mock
    ITaskService taskService;

    @Test
    public void testGetTask() {
        long taskId=16779;
        Task task = new Task();
        when(taskService.getTask(taskId)).thenReturn(task);
       ResponseEntity<com.scgapps.mobile.api.calendar.model.Task> task1=  taskController.getTask(taskId);

        assertEquals(200,task1.getStatusCodeValue());

    }

    @Test
    public void testGetAccountTask() {
        Integer taskId=16779;
        List<Task> tasks = new ArrayList<>();
        Task task = new Task();
        tasks.add(task);
        when(taskService.getAccountTasks(taskId)).thenReturn(tasks);
        ResponseEntity<List<TaskSummary>> task1 = taskController.getAccountTask(taskId);
        assertEquals(200,task1.getStatusCodeValue());
    }
    @Test
    public void testGetProjectTask() {
        Integer projectId=16779;
        List<Task> tasks = new ArrayList<>();
        Task task = new Task();
        tasks.add(task);
        when(taskService.getProjectTasks(projectId)).thenReturn(tasks);
        ResponseEntity<List<TaskSummary>> task1 = taskController.getProjectTask(projectId);
        assertEquals(200,task1.getStatusCodeValue());
    }

    @Test
    public void testGetContactTask() {
        long taskId=16779;
        List<Task> tasks = new ArrayList<>();
        Task task = new Task();
        tasks.add(task);
        when(taskService.getContactTasks(taskId)).thenReturn(tasks);
        ResponseEntity<List<TaskSummary>> task1 = taskController.getContactTask(taskId);
        assertEquals(200,task1.getStatusCodeValue());
    }
}