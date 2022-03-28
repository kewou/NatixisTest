package com.natixis.noumiaTest.Services;

import com.natixis.noumiaTest.entities.Task;
import com.natixis.noumiaTest.services.TaskService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ServiceTest {
    
    public int nbTaskDatabase = 3;
    public int nbTaskToDo = 2;
    
    @Autowired
    private TaskService taskService;
    
    @Test
    @Order(7)
    void contextLoads() {
    }
    
    @Test
    @Order(1)
    public void testGetAllTask() {
        int res = taskService.getAllTask().size();
        assertEquals(nbTaskDatabase, res);
    }
    
    @Test
    @Order(2)
    public void testGetToDoList() {
        int res = taskService.getToDoList().size();
        assertEquals(nbTaskToDo, res);
    }    
    
    @Test
    @Order(3)
    public void testGetTask() {
        Long id = 3L;
        String label="Connect Database";
        assertEquals(label, taskService.getTask(id).getLabel());
    }
    
    @Test
    @Order(4)
    public void testAddTask() {
        Task Task = new Task();
        //Task.setId(Long.valueOf(4));
        Task.setLabel("Realese");        
        taskService.addOrUpdate(Task);
        assertEquals(taskService.getAllTask().size(), nbTaskDatabase + 1);
    }
    
    @Test
    @Order(5)
    public void testUpdateTask() {
        Long id = 2L;
        Task task = taskService.getTask(id);
        task.setCompleted(true);
        taskService.addOrUpdate(task);
        assertEquals(true, task.isCompleted());
    }
    
    @Test
    @Order(6)
    public void testDelete() {
        taskService.delete(Long.valueOf(4));
        assertEquals(taskService.getAllTask().size(), nbTaskDatabase);
    }
}
