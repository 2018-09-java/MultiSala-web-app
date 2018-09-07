/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.factory;

import com.example.model.Film;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

/**
 *
 * @author ultra
 */
class FilmMemoryImpl {

    static List<Film> getAll() {
        List<Film> films = new ArrayList();
        try {
            Film film = new Film.Builder()
                    .setTitle("Mission Impossible")
                    .setGenere("Azione")
                    .setCast("Tom Cruise")
                    .setDurata(146)
                    .setDataUscita(LocalDate.of(2018, Month.JULY, 12))
                    .setImgUrl("MissionImpossible.jpg")
                    .setData(LocalDate.now())
                    .setSala(5)
                    .setPosti(190)
                    .setOrario("19:00  21:00  22:30")
                    .build();
            films.add(film);
            film = new Film.Builder()
                    .setTitle("Gli Incredibili 2")
                    .setGenere("Animazione")
                    .setCast("Bebe Vio")
                    .setDurata(118)
                    .setDataUscita(LocalDate.of(2018, Month.SEPTEMBER, 19))
                    .setImgUrl("GliIncredibili2.jpg")
                    .setData(LocalDate.now())
                    .setSala(2)
                    .setPosti(170)
                    .setOrario("16:00  19:00  21:00")
                    .build();
            films.add(film);
            film = new Film.Builder()
                    .setTitle("Shark - Il primo squalo")
                    .setGenere("Azione")
                    .setCast("Jason Statham")
                    .setDurata(113)
                    .setDataUscita(LocalDate.of(2018, Month.AUGUST, 9))
                    .setImgUrl("Shark.jpg")
                    .setData(LocalDate.now())
                    .setSala(1)
                    .setPosti(150)
                    .setOrario("19:00  21:00  22:30")
                    .build();
            films.add(film);
            film = new Film.Builder()
                    .setTitle("ANT-MAN and the Wasp")
                    .setGenere("Azione")
                    .setCast("Paul Rudd, Judy Greer")
                    .setDurata(118)
                    .setDataUscita(LocalDate.of(2018, Month.JULY, 4))
                    .setImgUrl("Ant-Man.jpg")
                    .setData(LocalDate.now())
                    .setSala(3)
                    .setPosti(150)
                    .setOrario("19:00  21:00  22:30")
                    .build();
            films.add(film);
        } catch (IllegalArgumentException e) {
            throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
        }
        return films;
    }

}
