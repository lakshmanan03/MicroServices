package com.scgapps.mobile.api.accounts.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "contacts_user_favorite")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@SuppressWarnings("unused")

public class FavoriteContact implements Serializable {

    @EmbeddedId
    private FavoriteContactId id;
    @MapsId("contactId")
    @OneToOne
    @JoinColumn(name = "contact_id", nullable = false)
    private Contact contact;
    public FavoriteContact(){}
    public FavoriteContact(FavoriteContactId favoriteContactId, Contact contact) {
        this.id = favoriteContactId;
        this.contact = contact;
    }

    public FavoriteContact contact(Contact contact) {
        this.contact = contact;
        return this;
    }
    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }


}
