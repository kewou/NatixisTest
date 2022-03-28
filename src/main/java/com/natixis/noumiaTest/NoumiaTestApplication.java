package com.natixis.noumiaTest;

import com.natixis.noumiaTest.entities.Task;
import com.natixis.noumiaTest.repository.TaskRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class NoumiaTestApplication {

	public static void main(String[] args) {		
                ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(NoumiaTestApplication.class, args);
                TaskRepository taskRepository = configurableApplicationContext.getBean(TaskRepository.class);
                
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
