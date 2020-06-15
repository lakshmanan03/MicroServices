package com.scgapps.mobile.api.accounts.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.List;

/**
 * A Notes.
 */
@Entity
@Table(name = "notes")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@SuppressWarnings("unused")
public class Notes implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "comments")
    private String comments;

    @Column(name = "created")
    private Instant created;

    @Column(name = "created_by")
    private Long createdBy;

    @Column(name = "create_task")
    private Integer createTask = 0;

    @Column(name = "deleted")
    private Integer deleted = 0;

    @Column(name = "deleted_by")
    private Integer deletedBy = 0;

    @Column(name = "deleted_time")
    private Instant deletedTime;

    @Column(name = "last_modified")
    private Instant lastModified;

    @Column(name = "last_modified_by")
    private Long lastModifiedBy;

    @Column(name = "primary_account")
    private Long primaryAccount;

    @Column(name = "product_line")
    private Integer productLine;

    @Column(name = "project")
    private Integer project;

    @Column(name = "subject")
    private String subject;

    @Column(name = "type")
    private String type;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "update_account_team")
    private Integer updateAccountTeam = 0;

    @Column(name = "update_project_team")
    private Integer updateProjectTeam = 0;

    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name = "note_contacts",
            joinColumns = @JoinColumn(name = "id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "contact", referencedColumnName = "contact"))
    private List<Contact> contact;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "primary_account", insertable = false, updatable = false)
    private Account account;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Instant getCreated() {
        return created;
    }

    public void setCreated(Instant created) {
        this.created = created;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public Integer getCreateTask() {
        return createTask;
    }

    public void setCreateTask(Integer createTask) {
        this.createTask = createTask;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    public Integer getDeletedBy() {
        return deletedBy;
    }

    public void setDeletedBy(Integer deletedBy) {
        this.deletedBy = deletedBy;
    }

    public Instant getDeletedTime() {
        return deletedTime;
    }

    public void setDeletedTime(Instant deletedTime) {
        this.deletedTime = deletedTime;
    }

    public Instant getLastModified() {
        return lastModified;
    }

    public void setLastModified(Instant lastModified) {
        this.lastModified = lastModified;
    }

    public Long getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(Long lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public Long getPrimaryAccount() {
        return primaryAccount;
    }

    public void setPrimaryAccount(Long primaryAccount) {
        this.primaryAccount = primaryAccount;
    }

    public Integer getProductLine() {
        return productLine;
    }

    public void setProductLine(Integer productLine) {
        this.productLine = productLine;
    }

    public Integer getProject() {
        return project;
    }

    public void setProject(Integer project) {
        this.project = project;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getUpdateAccountTeam() {
        return updateAccountTeam;
    }

    public void setUpdateAccountTeam(Integer updateAccountTeam) {
        this.updateAccountTeam = updateAccountTeam;
    }

    public Integer getUpdateProjectTeam() {
        return updateProjectTeam;
    }

    public void setUpdateProjectTeam(Integer updateProjectTeam) {
        this.updateProjectTeam = updateProjectTeam;
    }

    public List<Contact> getContact() {
        return contact;
    }

    public void setContact(List<Contact> contact) {
        this.contact = contact;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Notes)) {
            return false;
        }
        return id != null && id.equals(((Notes) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Notes{" +
                "id=" + getId() +
                ", comments='" + getComments() + "'" +
                ", created='" + getCreated() + "'" +
                ", createdBy=" + getCreatedBy() +
                ", createTask=" + getCreateTask() +
                ", deleted=" + getDeleted() +
                ", deletedBy=" + getDeletedBy() +
                ", deletedTime='" + getDeletedTime() + "'" +
                ", lastModified='" + getLastModified() + "'" +
                ", lastModifiedBy=" + getLastModifiedBy() +
                ", primaryAccount=" + getPrimaryAccount() +
                ", productLine=" + getProductLine() +
                ", project=" + getProject() +
                ", subject='" + getSubject() + "'" +
                ", type='" + getType() + "'" +
                "}";
    }
}
