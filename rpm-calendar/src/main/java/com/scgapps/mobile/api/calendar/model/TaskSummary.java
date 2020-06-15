package com.scgapps.mobile.api.calendar.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.time.Instant;
import java.util.Objects;

@Validated
public class TaskSummary {

    @JsonProperty("id")
    private long id = 1234;

    @JsonProperty("details")
    private String details = "My Current Task";

    @JsonProperty("lastModified")
    private Instant lastModified = null;

    /**
     * Get Task Id
     * @return -- taskID
     */
    @Valid

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    /**
     * Get Task Details
     * @return -- Task Details
     */
    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    /**
     * Get Last Modified date on this task
     * @return -- last Modified
     */
    public Instant getLastModified() {
        return lastModified;
    }

    public void setLastModified(Instant lastModified) {
        this.lastModified = lastModified;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaskSummary task = (TaskSummary) o;
        return id == task.id &&
                Objects.equals(details, task.details) &&
                Objects.equals(lastModified, task.lastModified);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, details, lastModified);
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", details='" + details + '\'' +
                ", lastModified=" + lastModified +
                '}';
    }
}
