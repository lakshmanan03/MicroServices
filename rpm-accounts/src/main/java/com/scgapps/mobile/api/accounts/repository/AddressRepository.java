package com.scgapps.mobile.api.accounts.repository;

import com.scgapps.mobile.api.accounts.domain.Address;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Spring Data  repository for the Address entity.
 */
@SuppressWarnings("unused")
@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

    @Query(value="SELECT * FROM ADDRESSES adr, ACCOUNT_ADDRESSES acdr  WHERE adr.id=acdr.address_id and acdr.account_id=:accountId",nativeQuery = true)
    List<Address> findAllWithEagerRelationships(@Param("accountId") long accountId);

}
