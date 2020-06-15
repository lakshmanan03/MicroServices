package com.scgapps.mobile.api.calendar.service;


import com.scgapps.mobile.api.calendar.domain.Task;

import java.util.List;


public interface ITaskService {

    Task getTask(Long id);

    List<Task> getAccountTasks(Integer accountId);

    List<Task> getProjectTasks(Integer projectId);

    List<Task> getContactTasks(Long contactId);
}
