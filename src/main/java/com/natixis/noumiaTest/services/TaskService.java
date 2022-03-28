package com.natixis.noumiaTest.services;

import com.natixis.noumiaTest.entities.Task;
import java.util.List;

/**
 *
 * @author frup73532
 */
public interface TaskService {

    Task getTask(Long id);

    List<Task> getAllTask();
    
    List<Task> getToDoList();

    void delete(Long id);

    void addOrUpdate(Task task);

    
}
