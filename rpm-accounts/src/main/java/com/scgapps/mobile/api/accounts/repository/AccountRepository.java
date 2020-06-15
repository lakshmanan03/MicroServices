package com.scgapps.mobile.api.accounts.repository;

import com.scgapps.mobile.api.accounts.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Spring Data  repository for the Account entity.
 */
@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    @Query("select distinct accounts from Account accounts join fetch accounts.contacts left join fetch accounts.addresses join fetch accounts.location")
    List<Account> findAllWithEagerRelationships();

    @Query("select accounts from Account accounts join fetch accounts.contacts left join fetch accounts.addresses join fetch accounts.location where accounts.id =:id")
    Optional<Account> findOneWithEagerRelationships(@Param("id") Long id);
}
