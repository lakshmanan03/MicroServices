package com.scgapps.mobile.api.accounts.service;

import com.scgapps.mobile.api.accounts.domain.Contact;
import com.scgapps.mobile.api.accounts.model.ContactRequest;
import com.scgapps.mobile.api.accounts.model.UserFavoriteContact;

import java.util.List;

public interface IContactService {
    Contact updateContact(ContactRequest contactRequest);
    Contact getContactSummary(Long id);
    List<Contact> getFavoriteContacts(Long id);
    List<Integer> getFavoriteContactList(Long userId);
    long saveFavoriteContact(UserFavoriteContact userFavoriteContact);
	long removeFavoriteContact(UserFavoriteContact userFavoriteContact);

    /**
     * Add new contact for an account.
     * @param contactRequest -- Add Contact request object
     * @return -- Add contact response status.
     */
    Contact addContact(ContactRequest contactRequest);
    Contact deleteContact(long contactId);
}
