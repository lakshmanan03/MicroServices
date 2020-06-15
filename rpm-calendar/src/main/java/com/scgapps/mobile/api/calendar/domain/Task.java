package com.scgapps.mobile.api.calendar.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.List;

/**
 * A Task.
 */
@Entity
@Table(name = "tasks")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Task implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "assigner_user_id")
    private Integer assignerUserId;

    @Column(name = "completed")
    private Integer completed;


    @Column(name = "created")
    private Instant created;

    @Column(name = "created_by")
    private Integer createdBy;

    @Column(name = "deleted")
    private Integer deleted;

    @Column(name = "deleted_by")
    private Integer deletedBy;

    @Column(name = "deleted_time")
    private Instant deletedTime;

    @Column(name = "details")
    private String details;

    @Column(name = "last_modified")
    private Instant lastModified;

    @Column(name = "last_modified_by")
    private Integer lastModifiedBy;

    @Column(name = "note_id")
    private Integer noteId;

    @Column(name = "notify_on_completion")
    private Integer notifyOnCompletion;


    @Column(name = "primary_account")
     private Integer primaryAccount;

    @Column(name = "product_line")
    private Integer productLine;

    @Column(name = "project")
    private Integer project;

    @Column(name = "reminder")
    private Integer reminder;

    @Column(name = "send_text")
    private Integer sendText;

    @Column(name = "task_date")
    private Instant taskDate;

    @Column(name = "time_zone")
    private String timeZone;

    @Column(name = "type")
    private Integer type;

    @Column(name = "user_id")
    private Integer userId;

    @ManyToMany
     @JoinTable(name = "task_contacts",
            joinColumns = @JoinColumn(name = "id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "contact", referencedColumnName = "contact"))
    private List<Contact> contact;

    public List<Contact> getContact() {
        return contact;
    }

    public void setContact(List<Contact> contact) {
        this.contact = contact;
    }

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAssignerUserId() {
        return assignerUserId;
    }

    public Task assignerUserId(Integer assignerUserId) {
        this.assignerUserId = assignerUserId;
        return this;
    }



    public Integer getPrimaryAccount() {
        return primaryAccount;
    }

    public void setPrimaryAccount(Integer primaryAccount) {
        this.primaryAccount = primaryAccount;
    }

    public void setAssignerUserId(Integer assignerUserId) {
        this.assignerUserId = assignerUserId;
    }

    public Integer getCompleted() {
        return completed;
    }

    public Task completed(Integer completed) {
        this.completed = completed;
        return this;
    }

    public void setCompleted(Integer completed) {
        this.completed = completed;
    }

    public Instant getCreated() {
        return created;
    }

    public Task created(Instant created) {
        this.created = created;
        return this;
    }

    public void setCreated(Instant created) {
        this.created = created;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public Task createdBy(Integer createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public Task deleted(Integer deleted) {
        this.deleted = deleted;
        return this;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    public Integer getDeletedBy() {
        return deletedBy;
    }

    public Task deletedBy(Integer deletedBy) {
        this.deletedBy = deletedBy;
        return this;
    }

    public void setDeletedBy(Integer deletedBy) {
        this.deletedBy = deletedBy;
    }

    public Instant getDeletedTime() {
        return deletedTime;
    }

    public Task deletedTime(Instant deletedTime) {
        this.deletedTime = deletedTime;
        return this;
    }

    public void setDeletedTime(Instant deletedTime) {
        this.deletedTime = deletedTime;
    }

    public String getDetails() {
        return details;
    }

    public Task details(String details) {
        this.details = details;
        return this;
    }

    public void setDetails(String details) {
        this.details = details;
    }


    public Instant getLastModified() {
        return lastModified;
    }

    public void setLastModified(Instant lastModified) {
        this.lastModified = lastModified;
    }

    public Integer getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(Integer lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public Integer getNoteId() {
        return noteId;
    }

    public Task noteId(Integer noteId) {
        this.noteId = noteId;
        return this;
    }

    public void setNoteId(Integer noteId) {
        this.noteId = noteId;
    }

    public Integer getNotifyOnCompletion() {
        return notifyOnCompletion;
    }

    public Task notifyOnCompletion(Integer notifyOnCompletion) {
        this.notifyOnCompletion = notifyOnCompletion;
        return this;
    }

    public void setNotifyOnCompletion(Integer notifyOnCompletion) {
        this.notifyOnCompletion = notifyOnCompletion;
    }


    public Integer getProductLine() {
        return productLine;
    }

    public Task productLine(Integer productLine) {
        this.productLine = productLine;
        return this;
    }

    public void setProductLine(Integer productLine) {
        this.productLine = productLine;
    }

    public Integer getProject() {
        return project;
    }

    public Task project(Integer project) {
        this.project = project;
        return this;
    }

    public void setProject(Integer project) {
        this.project = project;
    }

    public Integer getReminder() {
        return reminder;
    }

    public Task reminder(Integer reminder) {
        this.reminder = reminder;
        return this;
    }

    public void setReminder(Integer reminder) {
        this.reminder = reminder;
    }

    public Integer getSendText() {
        return sendText;
    }

    public Task sendText(Integer sendText) {
        this.sendText = sendText;
        return this;
    }

    public void setSendText(Integer sendText) {
        this.sendText = sendText;
    }

    public Instant getTaskDate() {
        return taskDate;
    }

    public Task taskDate(Instant taskDate) {
        this.taskDate = taskDate;
        return this;
    }

    public void setTaskDate(Instant taskDate) {
        this.taskDate = taskDate;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public Task timeZone(String timeZone) {
        this.timeZone = timeZone;
        return this;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public Integer getType() {
        return type;
    }

    public Task type(Integer type) {
        this.type = type;
        return this;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getUserId() {
        return userId;
    }

    public Task userId(Integer userId) {
        this.userId = userId;
        return this;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Task)) {
            return false;
        }
        return id != null && id.equals(((Task) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Task{" +
            "id=" + getId() +
            ", assignerUserId=" + getAssignerUserId() +
            ", completed=" + getCompleted() +
            ", created='" + getCreated() + "'" +
            ", createdBy=" + getCreatedBy() +
            ", deleted=" + getDeleted() +
            ", deletedBy=" + getDeletedBy() +
            ", deletedTime='" + getDeletedTime() + "'" +
            ", details='" + getDetails() + "'" +
            ", lastModified=" + getLastModified() +
            ", lastModifiedBy='" + getLastModifiedBy() + "'" +
            ", noteId=" + getNoteId() +
            ", notifyOnCompletion=" + getNotifyOnCompletion() +
            ", productLine=" + getProductLine() +
            ", project=" + getProject() +
            ", reminder=" + getReminder() +
            ", sendText=" + getSendText() +
            ", taskDate='" + getTaskDate() + "'" +
            ", timeZone='" + getTimeZone() + "'" +
            ", type=" + getType() +
            ", userId=" + getUserId() +
            "}";
    }
}
