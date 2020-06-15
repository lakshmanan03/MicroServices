package com.scgapps.mobile.api.calendar.repository;

import com.scgapps.mobile.api.calendar.domain.Task;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Spring Data  repository for the Contact entity.
 */
@SuppressWarnings("unused")
@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    @Query(value="select * from (select t.* from tasks t left outer join task_contacts tc on t.id = tc.id left outer join  contacts c on tc.contact=c.contact where c.contact=:id order by t.last_modified desc) where rownum <4",nativeQuery =true)
    List<Task> findAllWithEagerRelationships(@Param("id") Long id);

    List<Task> findTop3ByProjectOrderByLastModifiedDesc(Integer projectId);

    List<Task> findTop3ByPrimaryAccountOrderByLastModifiedDesc(Integer accountId);
}
