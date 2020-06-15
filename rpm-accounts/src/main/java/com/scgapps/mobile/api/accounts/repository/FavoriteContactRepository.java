package com.scgapps.mobile.api.accounts.repository;


import com.scgapps.mobile.api.accounts.domain.FavoriteContact;
import com.scgapps.mobile.api.accounts.domain.FavoriteContactId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FavoriteContactRepository  extends JpaRepository<FavoriteContact, FavoriteContactId> {
}
