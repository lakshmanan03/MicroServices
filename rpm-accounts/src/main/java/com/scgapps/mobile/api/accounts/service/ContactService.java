package com.scgapps.mobile.api.accounts.service;


import ch.qos.logback.classic.Logger;
import com.scgapps.mobile.api.accounts.domain.*;
import com.scgapps.mobile.api.accounts.model.ContactRequest;
import com.scgapps.mobile.api.accounts.model.UserFavoriteContact;
import com.scgapps.mobile.api.accounts.repository.*;
import com.scgapps.mobile.api.accounts.web.rest.errors.ErrorConstants;
import com.scgapps.mobile.api.library.rest.errors.RPMException;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Type;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ContactService implements IContactService {

    private final Logger logger = (Logger) LoggerFactory.getLogger(ContactService.class);

    @Value("${TEST_USER_ID}")
    private long testUserId;

    private PrimaryKeyRepository primaryKeyRepository;


    public final ContactRepository contactRepository;

    public final NotesRepository notesRepository;

    public final AddressRepository addressRepository ;


    public final FavoriteContactRepository favoriteContactRepository;

    public ContactService(ContactRepository contactRepository, FavoriteContactRepository favoriteContactRepository,
                          AddressRepository addressRepository, PrimaryKeyRepository primaryKeyRepository, NotesRepository notesRepository) {
        this.contactRepository = contactRepository;
        this.favoriteContactRepository = favoriteContactRepository;
        this.notesRepository = notesRepository;
        this.addressRepository = addressRepository;
        this.primaryKeyRepository = primaryKeyRepository;
    }

    /**
     * Updates a Contact based on provided contact id
     *
     * @param contactRequest -- Path parameter
     * @return -- Contact Summary with contacts, addresses and notes.
     */
    @Override
    @Transactional
    public Contact updateContact(ContactRequest contactRequest) {
        Contact contact = contactRepository.findById(contactRequest.getId()).orElseThrow(()
                -> RPMException.throwErrorMessage(HttpStatus.NOT_FOUND, ErrorConstants.contactNotFoundError));
        Contact contactEntity = updateContactObj(contact, contactRequest);
        return contactRepository.save(contactEntity);
    }

    @Transactional(readOnly = true)
    public Contact getContactSummary(Long id) {
        logger.debug("Request to get Contacts : {}", id);
        Contact contact = contactRepository.findOneWithEagerRelationships(id).orElseThrow(()
                -> RPMException.throwErrorMessage(HttpStatus.NOT_FOUND, ErrorConstants.contactNotFoundError));
        contact.setNotes(notesRepository.findAllWithEagerRelationships(id));
        return contact;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Contact> getFavoriteContacts(Long userId) {
        return contactRepository.findAllWithEagerRelationships(userId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Integer> getFavoriteContactList(Long userId) {
        return contactRepository.findAllContactsWithEagerRelationships(userId);
    }

    @Override
    @Transactional()
    public long saveFavoriteContact(UserFavoriteContact userFavoriteContact) {
        Contact contact = contactRepository.findById(userFavoriteContact.getContactId()).orElseThrow();
        FavoriteContactId favoriteContactId = new FavoriteContactId();
        favoriteContactId.setUserId(testUserId);
        favoriteContactId.setContactId(contact.getId());
        FavoriteContact favoriteContact = new FavoriteContact(favoriteContactId, contact);
        favoriteContactRepository.save(favoriteContact);
        return favoriteContact.getContact().getId();
    }

    @Override
    @Transactional()
    public long removeFavoriteContact(UserFavoriteContact userFavoriteContact) {
        Contact contact = contactRepository.findById(userFavoriteContact.getContactId()).orElseThrow();
        FavoriteContactId favoriteContactId = new FavoriteContactId();
        favoriteContactId.setUserId(testUserId);
        favoriteContactId.setContactId(contact.getId());
        FavoriteContact favoriteContact = new FavoriteContact(favoriteContactId, contact);
        favoriteContactRepository.delete(favoriteContact);
        return favoriteContact.getContact().getId();
    }

    /**
     * Add new contact for an account.
     *
     * @param contactRequest -- Add Contact request object
     * @return -- Add contact response.
     */
    @Override
    @Transactional()
    public Contact addContact(ContactRequest contactRequest) {
        return contactRepository.save(addContactObj(contactRequest));
    }

    /**
     * Removes a contact based on contactId
     *
     * @param contactId
     * @return contactId
     */
    @Override
    @Transactional
    public Contact deleteContact(long contactId) {
        Contact contact = contactRepository.findByIdAndDeleted(contactId, 0).orElseThrow(()
                -> RPMException.throwErrorMessage(HttpStatus.NOT_FOUND, ErrorConstants.contactNotFoundError));
        contact.setDeleted(1);
        contact.setDeletedBy((int) testUserId);
        contact.setDeletedTime(Instant.now());
        return contactRepository.save(contact);
    }

    private long getPrimaryKeySequence(String tableName) {
        Optional<PrimaryKeySequence> optionalPrimaryKeySequence = primaryKeyRepository.findById(tableName);
        PrimaryKeySequence primaryKeySequence;
        if (optionalPrimaryKeySequence.isPresent()) {
            primaryKeySequence = optionalPrimaryKeySequence.get();
        } else {
            primaryKeySequence = new PrimaryKeySequence();
            primaryKeySequence.setNextValue(1);
            primaryKeySequence.setTableName(tableName);
        }
        primaryKeySequence.setNextValue(primaryKeySequence.getNextValue() + 1);
        return primaryKeySequence.getNextValue();
    }

    /**
     * Add Contact Request Preparation.
     *
     * @param contactRequest
     * @return
     */
    private Contact addContactObj(ContactRequest contactRequest) {
        Contact contact = new Contact();
        contact.setId(getPrimaryKeySequence("CONTACTS"));
        contact.setCreated(Instant.now());
        contact.setCreatedBy((int) testUserId);
        getContactObj(contactRequest, contact, (int) testUserId);
        contact.setModifiable(0);
        if(contactRequest.getContactAddress()>0) {
            contact.setContactAddress((addressRepository.findById(contactRequest.getContactAddress()).orElseThrow(()
                    -> RPMException.throwErrorMessage(HttpStatus.NOT_FOUND, ErrorConstants.addressNotFoundError))));
        }
        AccountContact accountContact = new AccountContact();
        accountContact.setId(getPrimaryKeySequence("ACCOUNT_CONTACTS"));
        accountContact.setAccountId(contactRequest.getAccountId());
        List<AccountContact> contactList = new ArrayList<>();
        contactList.add(accountContact);
        /**
         * Setting Child object to the parent
         */
        contact.setAccountContact(contactList);
        /**
         * Setting parent object to the child
         */
        accountContact.setAccountContact(contact);

        if (contactRequest.getSocialMediaLinks() != null) {
            ModelMapper modelMapper = new ModelMapper();
            Type listType = new TypeToken<List<SocialMediaLink>>() {
            }.getType();
            List<SocialMediaLink> socialMediaLinkList = modelMapper.map(contactRequest.getSocialMediaLinks(), listType);
            socialMediaLinkList.forEach(socialMediaLink -> {
                socialMediaLink.setId(getPrimaryKeySequence("CONTACTS_SOCIAL_MEDIA_LINK"));
                socialMediaLink.setContact(contact);
            });
            contact.setSocialMediaLinks(socialMediaLinkList);
        }

        return contact;
    }

    /**
     * Contact Entity Preparation.
     *
     * @param contact, contactRequest
     * @return Contact
     */
    private Contact updateContactObj(Contact contact, ContactRequest contactRequest) {
        getContactObj(contactRequest, contact, (int) testUserId);
        contact.setId(contactRequest.getId());
        contact.setModifiable(1);
        if(contactRequest.getContactAddress()>0) {
            contact.setContactAddress((addressRepository.findById(contactRequest.getContactAddress()).orElseThrow(()
                    -> RPMException.throwErrorMessage(HttpStatus.NOT_FOUND, ErrorConstants.addressNotFoundError))));
        }
        if (contactRequest.getSocialMediaLinks() != null) {
            ModelMapper modelMapper = new ModelMapper();
            Type listType = new TypeToken<List<SocialMediaLink>>() {
            }.getType();
            List<SocialMediaLink> socialMediaLinkList = modelMapper.map(contactRequest.getSocialMediaLinks(), listType);
            socialMediaLinkList.forEach(socialMediaLink -> socialMediaLink.setContact(contact));
            contact.setSocialMediaLinks(socialMediaLinkList);
        }

        return contact;
    }

    private void getContactObj(ContactRequest contactRequest, Contact contact, int userId) {
        contact.setFirstName(contactRequest.getFirstName());
        contact.setMiddleName(contactRequest.getMiddleName());
        contact.setLastName(contactRequest.getLastName());
        contact.setLastModified(Instant.now());
        contact.setLastModifiedBy(userId);
        contact.setEmail(contactRequest.getEmail());
        contact.setFax(contactRequest.getFax());
        contact.setFaxExt(contactRequest.getFaxExt());
        contact.setWorkPhone(contactRequest.getWorkPhone());
        contact.setWorkPhoneExt(contactRequest.getWorkPhoneExt());
        contact.setCellPhone(contactRequest.getCellPhone());
        contact.setPhoneOther(contactRequest.getPhoneOther());
        contact.setPhoneOtherExt(contactRequest.getPhoneOtherExt());
        contact.setTitle(contactRequest.getTitle());
        contact.setDeleted(0);
    }
}