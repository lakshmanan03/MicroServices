package com.scgapps.mobile.api.accounts.web.rest;

import com.scgapps.mobile.api.accounts.domain.Contact;
import com.scgapps.mobile.api.accounts.model.*;
import com.scgapps.mobile.api.accounts.service.IContactService;
import com.scgapps.mobile.api.accounts.web.client.TasksClient;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.lang.reflect.Type;
import java.util.List;


@RestController
@RequestMapping("/api/accounts")
@Api(value = "RPM_CONTACT_SERVICE")
public class ContactsController {

    @Value("${TEST_USER_ID}")
    private long testUserId;

    private final IContactService contactService;
    private final TasksClient taskClient;

    public ContactsController(IContactService contactService, TasksClient taskClient) {
        this.contactService = contactService;
        this.taskClient = taskClient;

    }

    /**
     * Updates a Contact based on provided contact id
     *
     * @param contactRequest -- Path parameter
     * @return -- Contact Summary with contacts, addresses and notes.
     */
    @PutMapping("/contacts/updateContact")
    public ResponseEntity<ContactSummary> updateContact(@RequestBody ContactRequest contactRequest) {
        ModelMapper mapper = new ModelMapper();
        Contact contact = contactService.updateContact(contactRequest);
        ContactSummary contactSummary =mapper.map(contact, ContactSummary.class);
        if(contactRequest.getIsFavorite()==1    ) {
            contactService.saveFavoriteContact(new UserFavoriteContact(contact.getId()));
            contactSummary.setIsFavorite(1);
        }
        else{
            contactService.removeFavoriteContact(new UserFavoriteContact(contact.getId()));
            contactSummary.setIsFavorite(0);
        }

        return new ResponseEntity<>(contactSummary, HttpStatus.OK);
}




    /**
     * Account Summary of the provided account Id
     *
     * @param contactId -- Path parameter
     * @return -- Contact Summary with contacts, addresses and notes.
     */
    @GetMapping("/contacts/{contactId}")
    @ApiOperation(value = "Fetch the contact summary", response = ContactSummary.class)
    public ResponseEntity<ContactSummary> getContacts(@PathVariable long contactId) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.typeMap(Contact.class, ContactSummary.class).addMappings(mapper -> {
            mapper.map(src -> src.getAccount().getName(),
                    ContactSummary::setAccountName);
            mapper.map(src -> src.getAccount().getId(), ContactSummary::setAccountId);
        });
        modelMapper.getConfiguration().setAmbiguityIgnored(true);
        List<Integer> favoriteIds = contactService.getFavoriteContactList(testUserId);
        ContactSummary contactSummary = modelMapper.map(contactService.getContactSummary(contactId), ContactSummary.class);
        contactSummary.setContactTasks(taskClient.getContactTask(contactId).getBody());
        long cId = contactSummary.getId();
        if (favoriteIds.contains((int) cId)) {
            contactSummary.setIsFavorite(1);
        }
        return ResponseEntity.ok()
                .body(contactSummary);
    }

    @GetMapping("/contacts/favorites")
    @ApiOperation(value = "Fetch the favorite contacts", response = List.class)
    public ResponseEntity<Object> getFavoriteContacts(@RequestParam(name = "isOnlyContactId", required = false) boolean isOnlyContactId) {
        //harcoded user id for time being until authentication service is integrated
        Type listType = new TypeToken<List<FavoriteContactSummary>>() {
        }.getType();
        List<FavoriteContactSummary> favoriteContactSummaryList;
        if (!isOnlyContactId) {
            ModelMapper modelMapper = new ModelMapper();
            modelMapper.typeMap(Contact.class, FavoriteContactSummary.class).addMappings(mapper -> {
                mapper.map(Contact::getFirstName,
                        FavoriteContactSummary::setFirstName);
                mapper.map(Contact::getLastName,
                        FavoriteContactSummary::setLastName);
                mapper.map(Contact::getId,
                        FavoriteContactSummary::setId);
                mapper.map(src -> src.getAccount().getName(),
                        FavoriteContactSummary::setAccountName);
                mapper.map(src -> src.getAccount().getId(),
                        FavoriteContactSummary::setAccountId);
            });
            favoriteContactSummaryList = modelMapper.map(contactService.getFavoriteContacts(testUserId), listType);
            return ResponseEntity.ok().body(favoriteContactSummaryList);
        } else {

            return ResponseEntity.ok().body(contactService.getFavoriteContactList(testUserId));
        }


    }

    @PostMapping("/contacts/addFavorite")
    @ApiOperation(value = "Add Favorite contact", response = PostResponse.class)
    public ResponseEntity<PostResponse> insertFavoriteContacts(@RequestBody UserFavoriteContact userFavoriteContact) {
        PostResponse response = new PostResponse();
        response.setId(contactService.saveFavoriteContact(userFavoriteContact));
        response.setMessage("Created successfully");
        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping("/contacts/removeFavorite")
    @ApiOperation(value = "Remove Favorite contact", response = PostResponse.class)
    public ResponseEntity<PostResponse> removeFavoriteContacts(@RequestBody UserFavoriteContact userFavoriteContact) {
        PostResponse response = new PostResponse();
        response.setId(contactService.removeFavoriteContact(userFavoriteContact));
        response.setMessage("Removed successfully");
        return ResponseEntity.ok().body(response);
    }

    /**
     * Add a new contact to the account.
     *
     * @param contactRequest -- Add Contact Request Object.
     * @return - Return Add Contact Status.
     */
    @PostMapping("/contacts/addContact")
    @ApiOperation(value = "Add contact", response = Contacts.class)
    public ResponseEntity<Contacts> addContacts(@Valid @RequestBody ContactRequest contactRequest) {
        ModelMapper modelMapper = new ModelMapper();
        Contacts contacts = modelMapper.map(contactService.addContact(contactRequest), Contacts.class);
        if(contactRequest.getIsFavorite()==1)
        {
            contactService.saveFavoriteContact(new UserFavoriteContact(contacts.getId()));
            contacts.setIsFavorite(1);
        }
        return new ResponseEntity<>(contacts, HttpStatus.CREATED);
    }

    /**
     * Removes a contact based on contactId
     *
     * @param contactId
     * @return contactId
     */
    @PostMapping("/contacts/deleteContact/{contactId}")
    @ApiOperation(value = "Remove contact", response = Long.class)
    public ResponseEntity<Contacts> deleteContact(@PathVariable long contactId) {
        Contact contact = contactService.deleteContact(contactId);
        ModelMapper mapper = new ModelMapper();
        return new ResponseEntity<>(mapper.map(contact, Contacts.class), HttpStatus.OK);
    }
}