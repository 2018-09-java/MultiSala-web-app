/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.controllers;

import com.example.model.Film;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author ultra
 */
public class Films extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
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

            } catch (IllegalArgumentException e) {
                response.setStatus(500);
            }
            
            JSONArray jsonArray = new JSONArray();

            films.forEach(
                    f -> {
                        JSONObject filmJson = new JSONObject();
                        filmJson.put("code", f.getTitle());
                        filmJson.put("from", f.getGenere());
                        filmJson.put("to", f.getCast());
                        filmJson.put("durata", f.getDurata());
                        filmJson.put("dataUscita", f.getDataUscita());
                        jsonArray.put(filmJson);
                    }
            );

            rootObj.put("flights", jsonArray);

            out.print(rootObj);
            
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
