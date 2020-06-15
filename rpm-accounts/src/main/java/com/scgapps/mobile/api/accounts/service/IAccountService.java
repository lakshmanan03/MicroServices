package com.scgapps.mobile.api.accounts.service;

import com.scgapps.mobile.api.accounts.domain.Account;
import com.scgapps.mobile.api.accounts.domain.Address;

import java.util.List;

public interface IAccountService {
    List<Account> findAll();
    Account getAccountSummary(long id);
    List<Address> getAddresses(long accountId);

}
