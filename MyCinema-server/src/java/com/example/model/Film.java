/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.model;

import java.time.LocalDate;

/**
 *
 * @author ultra
 */
public class Film {

    private String title;
    private String genere;
    private String cast;
    private int durata;
    private LocalDate dataUscita;

    private Film() {

    }

    public String getTitle() {
        return title;
    }

    public String getGenere() {
        return genere;
    }

    public String getCast() {
        return cast;
    }

    public int getDurata() {
        return durata;
    }

    public LocalDate getDataUscita() {
        return dataUscita;
    }

    public static class Builder {

        private String title = "";
        private String genere = "Unknown";
        private String cast = "Unknown";
        private int durata = 0;
        private LocalDate dataUscita = LocalDate.now();

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setGenere(String genere) {
            this.genere = genere;
            return this;
        }

        public Builder setCast(String cast) {
            this.cast = cast;
            return this;
        }

        public Builder setDurata(int durata) {
            this.durata = durata;
            return this;
        }

        public Builder setDataUscita(LocalDate dataUscita) {
            this.dataUscita = dataUscita;
            return this;
        }

        public Film build() {
            if (this.title.isEmpty()) {
                throw new IllegalArgumentException("Film title is not set. Please set it.");
            }
            if ((this.genere.equals("Unknown")
                    && !this.cast.equals("Unknown"))
                    || (this.cast.equals("Unknown")
                    && !this.genere.equals("Unknown"))) {
                throw new IllegalArgumentException("Genere or cast should be both set or default. Please set both of them or leave the default values.");
            }

            Film film = new Film();
            film.title = this.title;
            film.genere = this.genere;
            film.cast = this.cast;
            film.durata = this.durata;
            film.dataUscita = this.dataUscita;
            return film;
        }

    }

}
