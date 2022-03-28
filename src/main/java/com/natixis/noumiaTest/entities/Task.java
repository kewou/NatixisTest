/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.natixis.noumiaTest.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import lombok.Data;
import org.springframework.data.annotation.Id;

/**
 *
 * @author frup73532
 */
 
@Entity
@Table(name="task")
@Data
public class Task implements Serializable{
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @javax.persistence.Id
    private Long id;
	
    @Column(name = "label", nullable = false)
    private String label;	
		
    @Column(name = "isCompleted")
    private boolean isCompleted = false;
	
    
}
