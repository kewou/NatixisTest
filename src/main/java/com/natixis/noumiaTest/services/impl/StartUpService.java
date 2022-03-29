/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.natixis.noumiaTest.services.impl;

import com.natixis.noumiaTest.entities.Task;
import com.natixis.noumiaTest.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

/**
 *
 * @author frup73532
 */

@Service
public class StartUpService implements CommandLineRunner{
    
    @Autowired
    TaskRepository taskRepository;

    @Override
    public void run(String... args) throws Exception {
        // Insertion des données pour la réalisation des tests
        Task task1 = new Task();
        task1.setLabel("Init project");
        task1.setCompleted(true);
        Task task2 = new Task();
        task2.setLabel("Dev service");                
        Task task3 = new Task();
        task3.setLabel("Connect Database");                
        taskRepository.save(task1);
        taskRepository.save(task2);
        taskRepository.save(task3);                
    }
    
}
