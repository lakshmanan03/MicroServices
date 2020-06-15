package com.scgapps.mobile.api.accounts.service;

import com.scgapps.mobile.api.accounts.domain.Account;
import com.scgapps.mobile.api.accounts.domain.Address;
import com.scgapps.mobile.api.accounts.repository.AccountRepository;
import com.scgapps.mobile.api.accounts.repository.AddressRepository;
import com.scgapps.mobile.api.accounts.repository.NotesRepository;
import com.scgapps.mobile.api.accounts.web.rest.errors.ErrorConstants;
import com.scgapps.mobile.api.library.rest.errors.RPMException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Service Implementation for managing {@link Account}.
 */
@Service
@Transactional
public class AccountService implements IAccountService {

    private final Logger log = LoggerFactory.getLogger(AccountService.class);

    private final AccountRepository accountRepository;

    private final NotesRepository notesRepository;

    private final AddressRepository addressRepository;

    public AccountService(AccountRepository accountRepository, NotesRepository notesRepository, AddressRepository addressRepository) {
        this.accountRepository = accountRepository;
        this.notesRepository = notesRepository;
        this.addressRepository = addressRepository;
    }


    /**
     * Get all the accounts.
     *
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public List<Account> findAll() {
        log.debug("Request to get all Accounts");
        return accountRepository.findAllWithEagerRelationships();
    }

    /**
     * Get all the accounts with eager load of many-to-many relationships.
     *
     * @return the list of entities.
     */

    /**
     * Get account Summary for a given id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Account getAccountSummary(long id) {
        log.debug("Request to get Accounts : {}", id);
        Account account= accountRepository.findOneWithEagerRelationships(id).orElseThrow(()
                -> RPMException.throwErrorMessage(HttpStatus.NOT_FOUND,ErrorConstants.accountNotFoundError));
         account.setNotes(notesRepository.findTop3ByPrimaryAccountOrderByLastModifiedDesc(id));
         return account;
    }

    @Override
    public List<Address> getAddresses(long accountId) {
        log.debug("Request to get Addresses for account : {}", accountId);
        return addressRepository.findAllWithEagerRelationships(accountId);
    }

}
