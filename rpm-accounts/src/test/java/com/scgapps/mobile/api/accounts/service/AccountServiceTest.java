package com.scgapps.mobile.api.accounts.service;

import com.scgapps.mobile.api.accounts.domain.Account;
import com.scgapps.mobile.api.accounts.domain.Address;
import com.scgapps.mobile.api.accounts.repository.AccountRepository;
import com.scgapps.mobile.api.accounts.repository.AddressRepository;
import com.scgapps.mobile.api.library.rest.errors.RPMException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("test")
public class AccountServiceTest {

	@InjectMocks
	private AccountService accountService;

	@Mock
	private AccountRepository accountRepository;

	@Mock
	private AddressRepository addressRepository;


	@Test
	public void testFindAll() {
		List<Account> accountList = new ArrayList<>();
		Account account = new Account();
		account.setId((long) 334545);
		account.setCreated(Instant.now());
		accountList.add(account);
		when(accountRepository.findAllWithEagerRelationships()).thenReturn(accountList);
		List<Account> accountList1 = accountService.findAll();
		assertEquals(accountList1,accountList);
	}

	@Test
	public void testGetAccountSummary() {
		long id = 199345;
		Account account = new Account();
		account.setId((long) 334545);
		account.setCreated(Instant.now());
		when(accountRepository.findOneWithEagerRelationships(id)).thenReturn(java.util.Optional.of(account));
		Account account1=accountService.getAccountSummary(id);
		assertEquals(account1,account);

	}

	@Test
	public void testGetAddresses() {
		long accountId = 199345;
		List<Address> addresses = new ArrayList<>();
		Address address = new Address();
		address.setId((long)3455);
		addresses.add(address);
		when(addressRepository.findAllWithEagerRelationships(accountId)).thenReturn(addresses);
		List<Address> addresList=accountService.getAddresses(accountId);
		assertEquals(addresList.get(0).getId(),addresses.get(0).getId());

	}

	@Test(expected = RPMException.class)
	public void testGetAccountSummaryException() {
		long id = 199345;
		accountService.getAccountSummary(id);

	}

}
