package com.scgapps.mobile.api.accounts.web.rest;

import com.scgapps.mobile.api.accounts.domain.Account;
import com.scgapps.mobile.api.accounts.domain.Address;
import com.scgapps.mobile.api.accounts.domain.Contact;
import com.scgapps.mobile.api.accounts.model.AccountContact;
import com.scgapps.mobile.api.accounts.model.AccountSummary;
import com.scgapps.mobile.api.accounts.model.TaskSummary;
import com.scgapps.mobile.api.accounts.service.IAccountService;
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

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;


@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("test")
public class AccountsControllerTest {

    @InjectMocks
    private AccountsController accountsController;

    @Mock
    IAccountService accountService;

    @Mock
    IContactService contactService;

    @Mock
    TasksClient taskClient;

    @Test
    public void getAccountsAddresses() {
        long accountId = 16779;
        List<Address> addresses = new ArrayList<>();
        Address address = new Address();
        address.setId((long)3455);
        addresses.add(address);
        when(accountService.getAddresses(accountId)).thenReturn(addresses);
        ResponseEntity<List<com.scgapps.mobile.api.accounts.model.Address>> addr = accountsController.getAccountAddresses(accountId);
        assertEquals(200, addr.getStatusCode().value());
            }
    @Test
    public void getAccounts() {
        long accountId = 16779;
        List<Integer> fContact = new ArrayList<>();
        fContact.add(1234);
        when(contactService.getFavoriteContactList(Mockito.anyLong())).thenReturn(fContact);
        when(accountService.getAccountSummary(accountId)).thenReturn(getAccount());
        ResponseEntity<List<TaskSummary>> ts = ResponseEntity.ok().body(new ArrayList<TaskSummary>());
        when(taskClient.getAccountTask((int) accountId)).thenReturn(ts);
        ResponseEntity<AccountSummary> accountSummary = accountsController.getAccounts(accountId);
        assertNotNull(accountSummary);
        assertEquals(200, accountSummary.getStatusCode().value());
        assertEquals("rpm", Objects.requireNonNull(accountSummary.getBody()).getName());
    }

    @Test
    public void getAccountContact() {
        long accountId = 16779;
        List<Integer> fContact = new ArrayList<>();
        fContact.add(1234);
        when(contactService.getFavoriteContactList(Mockito.anyLong())).thenReturn(fContact);
        when(accountService.getAccountSummary(accountId)).thenReturn(getAccount());
        ResponseEntity<AccountContact> accountContact = accountsController.getAccountContact(accountId);
        assertNotNull(accountContact);
        assertEquals(200, accountContact.getStatusCode().value());
        assertEquals("rpm", Objects.requireNonNull(accountContact.getBody()).getName());
    }

    private Set<Contact> getContacts(){
        Set<Contact> contacts = new HashSet<>();
        Contact contact = new Contact();
        contact.setId(1234l);
        contacts.add(contact);
        return contacts;
    }

    private Account getAccount(){
        Account account = new Account();
        account.setName("rpm");
        account.setContacts(getContacts());
        return account;
    }
}
