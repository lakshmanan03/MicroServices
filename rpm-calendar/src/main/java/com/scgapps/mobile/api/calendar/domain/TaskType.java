package com.scgapps.mobile.api.calendar.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;


/**
 * A TaskType.
 */
@Entity
@Table(name = "task_type")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class TaskType implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "ordering")
    private Integer ordering;

    @Column(name = "require_contacts")
    private Integer requireContacts;

    @Column(name = "selectable")
    private Integer selectable;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public TaskType name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getOrdering() {
        return ordering;
    }

    public TaskType ordering(Integer ordering) {
        this.ordering = ordering;
        return this;
    }

    public void setOrdering(Integer ordering) {
        this.ordering = ordering;
    }

    public Integer getRequireContacts() {
        return requireContacts;
    }

    public TaskType requireContacts(Integer requireContacts) {
        this.requireContacts = requireContacts;
        return this;
    }

    public void setRequireContacts(Integer requireContacts) {
        this.requireContacts = requireContacts;
    }

    public Integer getSelectable() {
        return selectable;
    }

    public TaskType selectable(Integer selectable) {
        this.selectable = selectable;
        return this;
    }

    public void setSelectable(Integer selectable) {
        this.selectable = selectable;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof TaskType)) {
            return false;
        }
        return id != null && id.equals(((TaskType) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "TaskType{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", ordering=" + getOrdering() +
            ", requireContacts=" + getRequireContacts() +
            ", selectable=" + getSelectable() +
            "}";
    }
}
