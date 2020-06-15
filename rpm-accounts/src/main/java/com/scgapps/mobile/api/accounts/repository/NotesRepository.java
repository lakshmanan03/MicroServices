package com.scgapps.mobile.api.accounts.repository;


import com.scgapps.mobile.api.accounts.domain.Notes;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Spring Data  repository for the Notes entity.
 */
@SuppressWarnings("unused")
@Repository
public interface NotesRepository extends CrudRepository<Notes, Long> {


    @Query(value="select * from (select nt.* from notes nt left outer join note_contacts tc on nt.id = tc.id left outer join  contacts c on tc.contact=c.contact where c.contact=:id order by nt.last_modified desc) where rownum <4",nativeQuery =true)
    List<Notes> findAllWithEagerRelationships(@Param("id") Long id);

    List<Notes> findTop3ByPrimaryAccountOrderByLastModifiedDesc(Long accountId);
}
