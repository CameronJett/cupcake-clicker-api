package com.jett.tutorial.cupcakeclickerapi.Model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
    
    @Id
    @GeneratedValue
    private int id;

    private String name;
    private int clicks;
    
    private static final long serialVersionUID = 1L;
}