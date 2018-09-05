/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.model;

import java.time.LocalDate;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ultra
 */
public class FilmTest {
    
    public FilmTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    
    
    @Test
    public void testBuilderOK() {
        System.out.println("testBuilderOK");
        try {
            new Film.Builder()
                    .setTitle("AZ123")
                    .build();
        } catch (IllegalArgumentException e) {
            fail("Should use default values.");
        }
    }

    /**
     * Test of Builder, code not set.
     */
    @Test
    public void testBuilderNoTitle() {
        System.out.println("testBuilderNoTitle");
        try {
            new Film.Builder()
                    .build();
            fail("Title not set.");
        } catch (IllegalArgumentException e) {
        }
    }

   
    @Test
    public void testBuilderGenereCast1() {
        System.out.println("testBuilderGenereCast1");
        try {
            new Film.Builder()
                    .setTitle("Mission Impossible")
                    .setGenere("Azione")
                    .build();
            fail("Attribute To is not set.");
        } catch (IllegalArgumentException e) {
        }
    }

    /**
     * Test of Builder, from is set, to not set.
     */
    @Test
    public void testBuilderGenereCast2() {
        System.out.println("testBuilderGenereCast2");
        try {
            new Film.Builder()
                    .setTitle("Mission Impossible")
                    .setCast("Rome")
                    .build();
            fail("Attribute From is not set.");
        } catch (IllegalArgumentException e) {
        }
    }

    /**
     * Test of Builder, from is set, to is set.
     */
    @Test
    public void testBuilderGenereCast3() {
        System.out.println("testBuilderGenereCast3");
        try {
            new Film.Builder()
                    .setTitle("Mission Impossible")
                    .setGenere("Rome")
                    .setCast("Munich")
                    .build();
        } catch (IllegalArgumentException e) {
            fail("Attributes From and To are both set.");
        }
        
        
    }
     @Test
    public void testBuilderDate() {
        System.out.println("testBuilderGenereCast3");
        try {
            Film film = new Film.Builder()
                    .setTitle("Mission Impossible")
                    .setGenere("Rome")
                    .setCast("Munich")                    
                    .build();
            assertEquals(LocalDate.now(), film.getDataUscita() );
        } catch (IllegalArgumentException e) {
            fail(e.getMessage());
        }
    }
    
}
