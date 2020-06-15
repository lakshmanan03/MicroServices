package com.scgapps.mobile.api.accounts.domain;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class FavoriteContactId  implements Serializable {

    private long contactId;
    private long userId;
    public FavoriteContactId(){}

    public FavoriteContactId(long contactId, long userId) {
        this.contactId = contactId;
        this.userId = userId;
    }

    public long getContactId() {
        return contactId;
    }

    public void setContactId(long contactId) {
        this.contactId = contactId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}
