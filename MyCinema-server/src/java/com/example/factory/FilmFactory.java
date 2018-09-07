/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.factory;

import com.example.model.Film;
import java.util.List;

/**
 *
 * @author ultra
 */
public class FilmFactory {
    public static List<Film> getAll(String implementionType) {
        
        if (implementionType.equals("MemoryImpl")){
        return FilmMemoryImpl.getAll();
        } else {
            throw new IllegalArgumentException("Implementation type not supported: "+implementionType+"Now only MemoryImpl is supported");
        }
    }
    
}
