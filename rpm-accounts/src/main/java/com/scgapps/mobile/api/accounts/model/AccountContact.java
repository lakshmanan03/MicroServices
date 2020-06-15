package com.scgapps.mobile.api.accounts.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * AccountSummary
 */
@Validated
@SuppressWarnings("unused")
public class AccountContact {
    @JsonProperty("id")
    private long id;

    @JsonProperty("name")
    private String name = null;

    @JsonProperty("contacts")
    private Set<Contacts> contacts = new HashSet<>();


    /**
     * Get id
     *
     * @return id
     **/

    @Valid

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    /**
     * Get name
     *
     * @return name
     **/

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    /**
     * Get accountContacts
     *
     * @return accountContacts
     **/

    public Set<Contacts> getContacts() {
        return contacts;
    }

    public void setContacts(Set<Contacts> contacts) {
        this.contacts = contacts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AccountContact)) return false;
        AccountContact that = (AccountContact) o;
        return getId() == that.getId() &&
                getName().equals(that.getName()) &&
                getContacts().equals(that.getContacts());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getContacts());
    }

    @Override
    public String toString() {
        return "AccountContact{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", contacts=" + contacts +
                '}';
    }
}

