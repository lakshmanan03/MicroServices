package com.scgapps.mobile.api.accounts.web.rest;

import com.scgapps.mobile.api.accounts.domain.Contact;
import com.scgapps.mobile.api.accounts.model.*;
import com.scgapps.mobile.api.accounts.service.IContactService;
import com.scgapps.mobile.api.accounts.web.client.TasksClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("test")
public class ContactsControllerTest {

    @InjectMocks
    private ContactsController contactsController;

    @Mock
    IContactService contactService;

    @Mock
    TasksClient taskClient;

    @Test
    public void testUpdateContact(){
        ContactRequest contactRequest = new ContactRequest();
        contactRequest.setIsFavorite(1);
        when(contactService.updateContact(contactRequest)).thenReturn(getContact());
        UserFavoriteContact userFavoriteContact = new UserFavoriteContact((long) 43535);
        when(contactService.saveFavoriteContact(userFavoriteContact)).thenReturn(getContact().getId());
        ResponseEntity<ContactSummary> response = contactsController.updateContact(contactRequest);
        assertNotNull(response);
        assertEquals(response.getBody().getFirstName(), "RPM");
    }

    @Test
    public void testUpdateRemoveFavoriteContact(){
        ContactRequest contactRequest = new ContactRequest();
        contactRequest.setIsFavorite(0);
        when(contactService.updateContact(contactRequest)).thenReturn(getContact());
        UserFavoriteContact userFavoriteContact = new UserFavoriteContact((long) 43535);
        when(contactService.removeFavoriteContact(userFavoriteContact)).thenReturn(getContact().getId());
        ResponseEntity<ContactSummary> response = contactsController.updateContact(contactRequest);
        assertNotNull(response);
        assertEquals(response.getBody().getFirstName(), "RPM");
    }

    @Test
    public void testGetContacts() {
        long contactId = 16779;
        List<Integer> favoriteIds = new ArrayList<>();
        favoriteIds.add(1234);
        when(contactService.getFavoriteContactList(Mockito.anyLong())).thenReturn(favoriteIds);
        when(contactService.getContactSummary(contactId)).thenReturn(getContact());
        ResponseEntity<List<TaskSummary>> ts = ResponseEntity.ok().body(new ArrayList<TaskSummary>());
        when(taskClient.getContactTask(contactId)).thenReturn(ts);
        ResponseEntity<ContactSummary> contactSummary = contactsController.getContacts(contactId);
        assertNotNull(contactSummary);
        assertEquals(200, contactSummary.getStatusCode().value());
        assertEquals("RPM", Objects.requireNonNull(contactSummary.getBody()).getFirstName());

    }

    @Test
    public void testGetFavoriteContacts() {
        long userId = 16779;
        List<Contact> contactList = new ArrayList<>();
        contactList.add(getContact());
        List<Integer> contactIds = new ArrayList<>();
        contactIds.add(43535);
        when(contactService.getFavoriteContacts(userId)).thenReturn(contactList);
        when(contactService.getFavoriteContactList(userId)).thenReturn(contactIds);
        ResponseEntity<Object> favoriteContacts = contactsController.getFavoriteContacts(true);
        ResponseEntity<Object> favoriteContactsIds = contactsController.getFavoriteContacts(false);
        assertEquals(200, favoriteContacts.getStatusCode().value());
        assertEquals(200, favoriteContactsIds.getStatusCode().value());
    }

    @Test
    public void testAddFavoriteContacts() {
        UserFavoriteContact userFavoriteContact = new UserFavoriteContact((long) 43535);
        userFavoriteContact.setContactId((long) 43535);
        when(contactService.saveFavoriteContact(userFavoriteContact)).thenReturn((long) 43535);
        ResponseEntity<PostResponse> favoriteContacts = contactsController.insertFavoriteContacts(userFavoriteContact);
        assertEquals(200, favoriteContacts.getStatusCode().value());
        assertEquals(200, favoriteContacts.getBody().getId(), userFavoriteContact.getContactId());
    }

    @Test
    public void testRemoveFavoriteContacts() {
        UserFavoriteContact userFavoriteContact = new UserFavoriteContact((long) 43535);
        userFavoriteContact.setContactId((long) 43535);
        when(contactService.saveFavoriteContact(userFavoriteContact)).thenReturn((long) 43535);
        ResponseEntity<PostResponse> favoriteContacts = contactsController.removeFavoriteContacts(userFavoriteContact);
        assertEquals(200, favoriteContacts.getStatusCode().value());
        assertEquals(200, favoriteContacts.getBody().getId(), userFavoriteContact.getContactId());
    }

    @Test
    public void testAddContacts(){
        ContactRequest contactRequest = new ContactRequest();
        contactRequest.setIsFavorite(1);
        when(contactService.addContact(contactRequest)).thenReturn(getContact());
        UserFavoriteContact ufc = new UserFavoriteContact(getContact().getId());
        when(contactService.saveFavoriteContact(ufc)).thenReturn(getContact().getId());
        ResponseEntity<Contacts> response = contactsController.addContacts(contactRequest);
        assertNotNull(response);
        assertEquals(response.getBody().getFirstName(), "RPM");
    }

    @Test
    public void testDeleteContact(){
        long contactId = 16779;
        when(contactService.deleteContact(contactId)).thenReturn(getContact());
        ResponseEntity<Contacts> response = contactsController.deleteContact(contactId);
        assertNotNull(response);
        assertEquals(response.getBody().getFirstName(), "RPM");
    }

    private Contact getContact(){
        Contact contact = new Contact();
        contact.setFirstName("RPM");
        contact.setId(1234L);
        return contact;
    }
}