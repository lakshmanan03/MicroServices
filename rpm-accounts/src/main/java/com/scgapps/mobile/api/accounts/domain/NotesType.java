package com.scgapps.mobile.api.accounts.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "note_type")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@SuppressWarnings("unused")
public class NotesType implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "ordering")
    private Integer ordering;

    @Column(name = "selectable")
    private Integer selectable;

    @Column(name = "require_contacts")
    private Integer requireContacts;

    @Column(name = "editable")
    private Integer editable;

    @Column(name = "short_name")
    private String shortName;

    @Column(name = "message_key")
    private String messageKey;

    @Column(name = "mergeable")
    private Integer mergeable;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getOrdering() {
        return ordering;
    }

    public void setOrdering(Integer ordering) {
        this.ordering = ordering;
    }

    public Integer getSelectable() {
        return selectable;
    }

    public void setSelectable(Integer selectable) {
        this.selectable = selectable;
    }

    public Integer getRequireContacts() {
        return requireContacts;
    }

    public void setRequireContacts(Integer requireContacts) {
        this.requireContacts = requireContacts;
    }

    public Integer getEditable() {
        return editable;
    }

    public void setEditable(Integer editable) {
        this.editable = editable;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getMessageKey() {
        return messageKey;
    }

    public void setMessageKey(String messageKey) {
        this.messageKey = messageKey;
    }

    public Integer getMergeable() {
        return mergeable;
    }

    public void setMergeable(Integer mergeable) {
        this.mergeable = mergeable;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NotesType notesType = (NotesType) o;
        return Objects.equals(id, notesType.id) &&
                Objects.equals(name, notesType.name) &&
                Objects.equals(ordering, notesType.ordering) &&
                Objects.equals(selectable, notesType.selectable) &&
                Objects.equals(requireContacts, notesType.requireContacts) &&
                Objects.equals(editable, notesType.editable) &&
                Objects.equals(shortName, notesType.shortName) &&
                Objects.equals(messageKey, notesType.messageKey) &&
                Objects.equals(mergeable, notesType.mergeable);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, ordering, selectable, requireContacts, editable, shortName, messageKey, mergeable);
    }

    @Override
    public String toString() {
        return "NotesType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", ordering=" + ordering +
                ", selectable=" + selectable +
                ", requireContacts=" + requireContacts +
                ", editable=" + editable +
                ", shortName=" + shortName +
                ", messageKey=" + messageKey +
                ", mergeable=" + mergeable +
                '}';
    }
}
