package com.scgapps.mobile.api.accounts.web.rest;

import ch.qos.logback.classic.Logger;
import com.scgapps.mobile.api.accounts.model.*;
import com.scgapps.mobile.api.accounts.service.IAccountService;
import com.scgapps.mobile.api.accounts.service.IContactService;
import com.scgapps.mobile.api.accounts.web.client.TasksClient;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api")
@Api(value = "RPM_ACCOUNT_SERVICE")
public class AccountsController {

    private final Logger logger = (Logger) LoggerFactory.getLogger(AccountsController.class);

    @Value("${TEST_USER_ID}")
    private long testUserId;

    private final IContactService contactService;
    private final IAccountService accountService;
    private final TasksClient taskClient;

    public AccountsController(IAccountService accountService, TasksClient taskClient, IContactService contactService) {
        this.accountService = accountService;
        this.taskClient = taskClient;
        this.contactService = contactService;
    }


    /**
     * Account Summary of the provided account Id
     *
     * @param accountId -- Path parameter
     * @return -- Account Summary with contacts, addresses and notes.
     */
    @GetMapping("/accounts/{accountId}")
    @ApiOperation(value = "Fetch the account summary", response = AccountSummary.class)
    public ResponseEntity<AccountSummary> getAccounts(@PathVariable Long accountId) {
        ModelMapper modelMapper = new ModelMapper();
        logger.debug("Get Account Summary for User:", testUserId);
        modelMapper.getConfiguration().setAmbiguityIgnored(true);
        AccountSummary accountSummary = modelMapper.map(accountService.getAccountSummary(accountId), AccountSummary.class);
       // accountSummary.setTasks(taskClient.getAccountTask((int) accountId).getBody());
        List<Contacts> contacts = accountSummary.getContacts();
        List<Integer> favoriteIds = contactService.getFavoriteContactList(testUserId);
        for (Contacts contact : contacts) {
            long cid = contact.getId();
            if (favoriteIds.contains((int) cid)) {
                contact.setIsFavorite(1);
            }
        }
        accountSummary.setContacts(contacts);
        return ResponseEntity.ok()
                .body(accountSummary);
    }

    @GetMapping("accounts/addresses/{accountId}")
    @ApiOperation(value = "Fetch addresses", response = Address.class)
    public ResponseEntity<List<Address>> getAccountAddresses(@PathVariable long accountId)
    {
        List<com.scgapps.mobile.api.accounts.domain.Address> addresses = accountService.getAddresses(accountId);
        ModelMapper modelMapper = new ModelMapper();
        Type listType = new TypeToken<List<Address>>() {
        }.getType();
        List<Address> addressList=   modelMapper.map(addresses,listType);
        return ResponseEntity.ok().body(addressList);
    }

    /**
     * Account Summary of the provided account Id
     *
     * @param accountId -- Path parameter
     * @return -- Account  with contacts.
     */
    @GetMapping("/account/accountContacts/{accountId}")
    @ApiOperation(value = "Fetch the account contact", response = AccountContact.class)
    public ResponseEntity<AccountContact> getAccountContact(@PathVariable long accountId) {
        ModelMapper modelMapper = new ModelMapper();
        logger.debug("Get Account Contact for User:", testUserId);
        modelMapper.getConfiguration().setAmbiguityIgnored(true);
        AccountContact accountContact = modelMapper.map(accountService.getAccountSummary(accountId), AccountContact.class);
        Set<Contacts> contacts = accountContact.getContacts();
        List<Integer> favoriteIds = contactService.getFavoriteContactList(testUserId);
        for (Contacts contact : contacts) {
            long cid = contact.getId();
            if (favoriteIds.contains((int) cid)) {
                contact.setIsFavorite(1);
            }
        }
        accountContact.setContacts(contacts);
        return ResponseEntity.ok().body(accountContact);
    }
}
