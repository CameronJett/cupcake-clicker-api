package com.jett.tutorial.cupcakeclickerapi.Model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private String name;
    private int clicks;
}