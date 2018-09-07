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
    private String imgUrl;
    private LocalDate data;
    private int sala;
    private int posti;
    private String orario;
    
    

    private Film() {

    }

    public String getImgUrl() {
        return imgUrl;
    }

    public LocalDate getData() {
        return data;
    }

    public int getSala() {
        return sala;
    }

    public int getPosti() {
        return posti;
    }

    public String getOrario() {
        return orario;
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
        private String imgUrl = "";
        private LocalDate data = LocalDate.now();
        private int sala = 0;
        private int posti = 0;
        private String orario= "";

        public Builder setImgUrl(String imgUrl) {
            this.imgUrl = imgUrl;
            return this;
        }
        
        public Builder setData(LocalDate data) {
            this.data = data;
            return this;
        }
        
        public Builder setSala(int sala) {
            this.sala=sala;
            return this;
        }
        
        public Builder setPosti(int posti) {
            this.posti = posti;
            return this;
        }
        
        public Builder setOrario(String orario) {
            this.orario = orario;
            return this;
        }

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
            film.imgUrl = this.imgUrl;
            film.data=this.data;
            film.sala=this.sala;
            film.posti=this.posti;
            film.orario=this.orario;
            return film;
        }

    }

}
