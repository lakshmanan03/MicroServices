package com.scgapps.mobile.api.calendar.domain;

import com.scgapps.mobile.api.calendar.config.Constant;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


/**
 * A Contact.
 */
@Entity
@Table(name = "contacts")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@SuppressWarnings("unused")
public class Contact implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "contact")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToMany
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    @Where(clause = "ROWNUM <= " + Constant.ACCOUNT_MAX_NOTES_COUNT)
    @OrderBy("last_modified desc")
    @JoinTable(name = "task_contacts",
            joinColumns = @JoinColumn(name = "contact", referencedColumnName = "contact"),
            inverseJoinColumns = @JoinColumn(name = "id", referencedColumnName = "id"))
    private Set<Task> tasks = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Task> getTasks() {
        return tasks;
    }

    public void setTasks(Set<Task> tasks) {
        this.tasks = tasks;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Contact)) {
            return false;
        }
        return id != null && id.equals(((Contact) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", tasks=" + tasks +
                '}';
    }
}
