package com.scgapps.mobile.api.accounts.service;

import com.scgapps.mobile.api.accounts.domain.*;
import com.scgapps.mobile.api.accounts.model.ContactRequest;
import com.scgapps.mobile.api.accounts.model.UserFavoriteContact;
import com.scgapps.mobile.api.accounts.repository.AddressRepository;
import com.scgapps.mobile.api.accounts.repository.ContactRepository;
import com.scgapps.mobile.api.accounts.repository.FavoriteContactRepository;
import com.scgapps.mobile.api.accounts.repository.PrimaryKeyRepository;
import com.scgapps.mobile.api.library.rest.errors.RPMException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("test")
public class ContactServiceTest {

    @InjectMocks
    private ContactService contactService;

    @Mock
    private ContactRepository contactRepository;

    @Mock
    private FavoriteContactRepository favoriteContactRepository;

    @Mock
    private AddressRepository addressRepository;

    @Mock
    private PrimaryKeyRepository primaryKeyRepository;

    @Test
    public void testUpdateContact() {
        long id = 1234l;
        long addressId = 5412l;
        Address address = new Address();
        address.setId(addressId);
        ContactRequest contactRequest = new ContactRequest();
        contactRequest.setId(id);
        contactRequest.setContactAddress(addressId);
        contactRequest.setFirstName("RPM");
        contactRequest.setLastName("ERP");
        com.scgapps.mobile.api.accounts.model.SocialMediaLink socialMediaLink = new com.scgapps.mobile.api.accounts.model.SocialMediaLink();
        socialMediaLink.setId(1L);
        socialMediaLink.setTypeId(4L);
        socialMediaLink.setUrl("http://www.linkedin.com");
        List<com.scgapps.mobile.api.accounts.model.SocialMediaLink> socialMediaLinks = new ArrayList<>();
        socialMediaLinks.add(socialMediaLink);
        contactRequest.setSocialMediaLinks(socialMediaLinks);
        when(contactRepository.save(Mockito.any())).thenReturn(getContact());
        when(addressRepository.findById(address.getId())).thenReturn(Optional.of(address));
        when(contactRepository.findById(id)).thenReturn(Optional.of(getContact()));
        Contact response = contactService.updateContact(contactRequest);
        assertNotNull(response);
        assertEquals(response.getId(), contactRequest.getId());
        assertEquals(response.getFirstName(), contactRequest.getFirstName());
    }

    @Test(expected = RPMException.class)
    public void testUpdateContactException() {
        Contact response = contactService.updateContact(new ContactRequest());
        assertNull(response);
    }

    @Test(expected = RPMException.class)
    public void testUpdateContactAddressNotFoundException() {
        long id = 1234l;
        long addressId = 5412l;
        ContactRequest contactRequest = new ContactRequest();
        contactRequest.setId(id);
        contactRequest.setContactAddress(addressId);
        contactRequest.setFirstName("RPM");
        contactRequest.setLastName("ERP");
        when(contactRepository.findById(id)).thenReturn(Optional.of(getContact()));
        Contact response = contactService.updateContact(contactRequest);
        assertNull(response);
    }

    @Test
    public void testGetContactSummary() {
        long id = 334545;
        when(contactRepository.findOneWithEagerRelationships(id)).thenReturn(java.util.Optional.of(getContact()));
        Contact contactSummary1 = contactService.getContactSummary(id);
        assertEquals(contactSummary1.getId(), getContact().getId());
    }

    @Test
    public void testGetFavoriteContactsList() {
        long userId = 1234l;
        List<Integer> contactIds = new ArrayList<>();
        contactIds.add(4345);
        when(contactRepository.findAllContactsWithEagerRelationships(userId)).thenReturn(contactIds);
        List<Integer> favoriteList = contactService.getFavoriteContactList(userId);
        assertEquals(favoriteList.get(0), contactIds.get(0));
    }

    @Test
    public void testGetFavoriteContacts() {
        long userId = 1234l;
        List<Contact> contactList = new ArrayList<>();
        contactList.add(getContact());
        when(contactRepository.findAllWithEagerRelationships(userId)).thenReturn(contactList);
        List<Contact> favoriteList = contactService.getFavoriteContacts(userId);
        assertEquals(favoriteList.get(0).getFirstName(), contactList.get(0).getFirstName());
    }

    @Test(expected = RPMException.class)
    public void testGetAccountSummaryException() {
        long id = 199345;
        Contact cs = contactService.getContactSummary(id);
        assertNull(cs);

    }

    @Test
    public void testSaveFavoriteContact() {
        long id = 1234l;
        when(contactRepository.findById(id)).thenReturn(java.util.Optional.of(getContact()));
        FavoriteContactId favoriteContactId = new FavoriteContactId();
        favoriteContactId.setUserId(id);
        favoriteContactId.setContactId(getContact().getId());
        FavoriteContact favoriteContact = new FavoriteContact(favoriteContactId, getContact());
        when(favoriteContactRepository.save(favoriteContact)).thenReturn(favoriteContact);
        UserFavoriteContact userFavoriteContact = new UserFavoriteContact(favoriteContactId.getContactId());
        userFavoriteContact.setContactId(getContact().getId());
        Long favoriteId = contactService.saveFavoriteContact(userFavoriteContact);
        assertEquals(favoriteId, favoriteContact.getContact().getId());

    }

    @Test
    public void testRemoveFavoriteContact() {
        long id = 1234L;
        when(contactRepository.findById(id)).thenReturn(java.util.Optional.of(getContact()));
        FavoriteContactId favoriteContactId = new FavoriteContactId();
        favoriteContactId.setUserId(id);
        favoriteContactId.setContactId(getContact().getId());
        FavoriteContact favoriteContact = new FavoriteContact(favoriteContactId, getContact());
        doNothing().when(favoriteContactRepository).delete(favoriteContact);
        UserFavoriteContact userFavoriteContact = new UserFavoriteContact(getContact().getId());
        userFavoriteContact.setContactId(getContact().getId());
        Long favoriteId = contactService.removeFavoriteContact(userFavoriteContact);
        assertEquals(favoriteId, favoriteContact.getContact().getId());

    }

    @Test
    public void testAddContact() {
        long id = 1234l;
        long addressId = 5412l;
        PrimaryKeySequence primaryKeySequence = new PrimaryKeySequence();
        Address address = new Address();
        address.setId(addressId);
        ContactRequest contactRequest = new ContactRequest();
        contactRequest.setId(id);
        contactRequest.setContactAddress(addressId);
        contactRequest.setFirstName("RPM");
        contactRequest.setLastName("ERP");
        com.scgapps.mobile.api.accounts.model.SocialMediaLink socialMediaLink = new com.scgapps.mobile.api.accounts.model.SocialMediaLink();
        socialMediaLink.setTypeId(4L);
        socialMediaLink.setUrl("http://www.linkedin.com");
        List<com.scgapps.mobile.api.accounts.model.SocialMediaLink> socialMediaLinks = new ArrayList<>();
        socialMediaLinks.add(socialMediaLink);
        contactRequest.setSocialMediaLinks(socialMediaLinks);
        when(contactRepository.save(Mockito.any())).thenReturn(getContact());
        when(addressRepository.findById(address.getId())).thenReturn(Optional.of(address));
        when(primaryKeyRepository.findById("CONTACTS")).thenReturn(Optional.of(primaryKeySequence));
        Contact response = contactService.addContact(contactRequest);
        assertNotNull(response);
        assertEquals(response.getId(), contactRequest.getId());
        assertEquals(response.getFirstName(), contactRequest.getFirstName());
    }

    @Test(expected = RPMException.class)
    public void testAddContactException() {
        long id = 1234l;
        long addressId = 5412l;
        ContactRequest contactRequest = new ContactRequest();
        contactRequest.setId(id);
        contactRequest.setContactAddress(addressId);
        contactRequest.setFirstName("RPM");
        contactRequest.setLastName("ERP");
        Contact response = contactService.addContact(contactRequest);
        assertNull(response);
    }

    @Test
    public void testDeleteContact() {
        long contactId = 1234l;
        when(contactRepository.save(Mockito.any())).thenReturn(getContact());
        when(contactRepository.findByIdAndDeleted(contactId, 0)).thenReturn(Optional.of(getContact()));
        Contact response = contactService.deleteContact(contactId);
        assertNotNull(response);
        assertEquals(response.getId(), contactId);
    }

    @Test(expected = RPMException.class)
    public void testDeleteContactException() {
        long contactId = 1234l;
        Contact response = contactService.deleteContact(contactId);
        assertNull(response);
    }

    private Contact getContact() {
        Contact contact = new Contact();
        contact.setFirstName("RPM");
        contact.setId(1234L);
        contact.setCreated(Instant.now());
        return contact;
    }

}
