package com.scgapps.mobile.api.accounts.repository;

import com.scgapps.mobile.api.accounts.domain.Contact;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Spring Data  repository for the Contact entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {

    @Query("select contacts from Contact contacts left join fetch contacts.notes cnotes where contacts.id =:id  and rownum < 4 order by cnotes.lastModified desc")
    Optional<Contact> findOneWithEagerRelationships(@Param("id") Long id);

    @Query("select distinct(contacts) from Contact contacts  inner join  FavoriteContact fc on fc.id.contactId =contacts.id  where fc.id.userId =:userId")
    List<Contact> findAllWithEagerRelationships(@Param("userId") Long usrid);

    @Query("select contacts.id from Contact contacts  inner join  FavoriteContact fc on fc.id.contactId =contacts.id  where fc.id.userId =:userId")
    List<Integer> findAllContactsWithEagerRelationships(@Param("userId") Long usrid);

    Optional<Contact> findByIdAndDeleted(long id, int deleted);

}