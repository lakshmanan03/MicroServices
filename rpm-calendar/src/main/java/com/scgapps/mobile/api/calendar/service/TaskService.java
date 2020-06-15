package com.scgapps.mobile.api.calendar.service;


import com.scgapps.mobile.api.calendar.domain.Task;
import com.scgapps.mobile.api.calendar.repository.TaskRepository;
import com.scgapps.mobile.api.calendar.rest.errors.ErrorConstants;
import com.scgapps.mobile.api.library.rest.errors.RPMException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class TaskService implements ITaskService {
    private final Logger log = LoggerFactory.getLogger(TaskService.class);
    public final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public Task getTask(Long id) {
        log.debug("Request to get Task : {}", id);
        return taskRepository.findById(id).orElseThrow(()
                -> RPMException.throwErrorMessage(HttpStatus.NOT_FOUND, ErrorConstants.taskNotFoundError));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Task> getAccountTasks(Integer accountId) {
        log.debug("Request to get Account Task : {}", accountId);
        return taskRepository.findTop3ByPrimaryAccountOrderByLastModifiedDesc(accountId);

    }

    @Override
    public List<Task> getProjectTasks(Integer projectId) {
        log.debug("Request to get Account Task : {}", projectId);
        return taskRepository.findTop3ByProjectOrderByLastModifiedDesc(projectId);
    }

    @Transactional(readOnly = true)
    public List<Task> getContactTasks(Long contactId) {
        log.debug("Request to get Contact Task : {}", contactId);
        return taskRepository.findAllWithEagerRelationships(contactId);

    }
}