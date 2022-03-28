/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.natixis.noumiaTest.controllers;

import com.natixis.noumiaTest.entities.Task;
import com.natixis.noumiaTest.services.TaskService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author frup73532
 */
@RestController
@RequestMapping("/tasks")
public class TaskController { 

    @Autowired
    private TaskService taskService;

    @GetMapping(path = "")
    public List<Task> getAllTaks() {
        return taskService.getAllTask();
    }

    @GetMapping(path = "/{id}")
    public Task getTask(@PathVariable("id") long id) {
        return taskService.getTask(id);
    }

    @GetMapping(path = "/toDo")
    public List<Task> getToDoList() {
        return taskService.getToDoList();
    }

    @PostMapping(path = "/{id}")
    public void addTask(@RequestBody Task task) {
        taskService.addOrUpdate(task);
    }

    @PutMapping(path = "/update")
    public Task updateStatus(@RequestBody Task task) {  
        taskService.addOrUpdate(task);
        return task;
    }

}
