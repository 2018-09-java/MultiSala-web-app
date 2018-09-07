/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.controllers;

import com.example.model.Film;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * REST Web Service
 *
 * @author Aincy
 */
@Path("films")
public class FilmsResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of FilmsResource
     */
    public FilmsResource() {
    }

    /**
     * Retrieves representation of an instance of com.example.controllers.FilmsResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    public String getJson() {
        JSONObject rootObj = new JSONObject();

        List<Film> films = new ArrayList();
        
         try {
            Film film = new Film.Builder()
                    .setTitle("Mission Impossible")
                    .setGenere("Azione")
                    .setCast("Tom Cruise")
                    .build();
            films.add(film);
            film = new Film.Builder()
                    .setTitle("Gli Incredibili 2")
                        .setGenere("Animazione")
                        .setCast("Bebe Vio")
                        .build();
            films.add(film);
            film = new Film.Builder()
                    .setTitle("Shark - Il primo squalo")
                        .setGenere("Azione")
                        .setCast("Jason Statham")
                        .build();
            films.add(film);
        } catch (IllegalArgumentException e) {
            throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
        }
        
         JSONArray jsonArray = new JSONArray();

        films.forEach(
                f -> {
                        JSONObject filmJson = new JSONObject();
                        filmJson.put("title", f.getTitle());
                        filmJson.put("genere", f.getGenere());
                        filmJson.put("cast", f.getCast());
                        filmJson.put("durata", f.getDurata());
                        filmJson.put("dataUscita", f.getDataUscita());
                        jsonArray.put(filmJson);
                    }
        );

        rootObj.put("flights", jsonArray);
        return rootObj.toString();
    }

    /**
     * PUT method for updating or creating an instance of FilmsResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
