package com.scgapps.mobile.api.accounts.repository;

import com.scgapps.mobile.api.accounts.domain.NotesType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@SuppressWarnings("unused")
@Repository
public interface NotesTypeRepository extends JpaRepository<NotesType, Long> {

}
