package com.scgapps.mobile.api.accounts.repository;

import com.scgapps.mobile.api.accounts.domain.PrimaryKeySequence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the Account entity.
 */
@Repository
public interface PrimaryKeyRepository extends JpaRepository<PrimaryKeySequence, String> {

}
