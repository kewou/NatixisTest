/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.natixis.noumiaTest.services.impl;

import com.natixis.noumiaTest.entities.Task;
import com.natixis.noumiaTest.repository.TaskRepository;
import com.natixis.noumiaTest.services.TaskService;
import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author frup73532
 */
@Service
@Transactional
public class TaskServiceImpl implements TaskService {
    
    @Autowired
    private TaskRepository taskRepository;
    
    @Override
    public Task getTask(Long id) {
        Task task = taskRepository.findById(id).orElse(null);                
        return task;
    }
    
    @Override
    public List<Task> getAllTask() {
        List<Task> tasks = new ArrayList<>();
        taskRepository.findAll().forEach(task -> tasks.add(task));
        return tasks;
    }
    
    @Override
    public List<Task> getToDoList() {
        return taskRepository.findToDoTask();
    }    
    
    @Override
    public void delete(Long id) {
        Task task = getTask(id);
        taskRepository.delete(task);
    }
    
    @Override
    public void addOrUpdate(Task task) {
        taskRepository.save(task);
    }

    
}
