package com.scgapps.mobile.api.calendar.service;


import com.scgapps.mobile.api.calendar.domain.Task;
import com.scgapps.mobile.api.calendar.repository.TaskRepository;
import com.scgapps.mobile.api.library.rest.errors.RPMException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
public class TaskServiceTest {

    @InjectMocks
    private TaskService taskService;

    @Mock
    private TaskRepository taskRepository;


    @Test
    public void testGetTask() {
        long id = 199345;
        Task task = new Task();
        task.setPrimaryAccount(34356);
        when(taskRepository.findById(id)).thenReturn(java.util.Optional.of(task));
        Task task1=taskService.getTask(id);
        assertEquals(task1.getPrimaryAccount(),task.getPrimaryAccount());
    }

    @Test(expected = RPMException.class)
    public void testGetTaskException() {
        Task task=taskService.getTask(5120l);
        assertNull(task);
    }

    @Test
    public void testGetProjectTasks() {
        Integer projectId=16779;
        List<Task> tasks = new ArrayList<>();
        Task task = new Task();
        task.setDetails("Meeting with Ethan");
        tasks.add(task);
        when(taskRepository.findTop3ByProjectOrderByLastModifiedDesc(projectId)).thenReturn(tasks);
        List<Task> task1=taskService.getProjectTasks(projectId);
        assertEquals(task1.get(0).getDetails(),tasks.get(0).getDetails());

    }

    @Test
    public void testGetAccountTasks() {
        Integer accountId=16779;
        List<Task> tasks = new ArrayList<>();
        Task task = new Task();
        task.setDetails("Meeting with Ethan");
        tasks.add(task);
        when(taskRepository.findTop3ByPrimaryAccountOrderByLastModifiedDesc(accountId)).thenReturn(tasks);
        List<Task> task1=taskService.getAccountTasks(accountId);
        assertEquals(task1.get(0).getDetails(),tasks.get(0).getDetails());

    }

    @Test
    public void testGetContactTasks() {

        long contactId=16779;
        List<Task> tasks = new ArrayList<>();
        Task task = new Task();
        task.setDetails("Meeting with Hunt");
        tasks.add(task);
        when(taskRepository.findAllWithEagerRelationships(contactId)).thenReturn(tasks);
        List<Task> task1=taskService.getContactTasks(contactId);
        assertEquals(task1.get(0).getDetails(),tasks.get(0).getDetails());
    }
}