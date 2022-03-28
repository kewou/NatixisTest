package com.natixis.noumiaTest.repository;

import com.natixis.noumiaTest.entities.Task;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author frup73532
 */
@Repository
public interface TaskRepository extends CrudRepository<Task, Long> {
    
    
    @Query("from Task t where t.isCompleted=false")
    public List<Task> findToDoTask();
}