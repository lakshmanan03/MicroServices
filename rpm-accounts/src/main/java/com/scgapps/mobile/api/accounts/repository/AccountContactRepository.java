package com.scgapps.mobile.api.accounts.repository;

import com.scgapps.mobile.api.accounts.domain.AccountContact;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountContactRepository extends CrudRepository<AccountContact, Long> {
}
