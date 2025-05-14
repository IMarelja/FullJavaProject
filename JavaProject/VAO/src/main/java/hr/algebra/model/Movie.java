/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hr.algebra.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author windsten
 */
public final class Movie {
    
    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.BASIC_ISO_DATE;
    
    private int id;
    private String title;
    private String picturePath;
    private String description;
    private LocalDateTime releaseDate;
    
    
    private List<Director> directors = new ArrayList<>();
    private List<Actor> actors = new ArrayList<>();
    private List<Genre> genres = new ArrayList<>();
    
    
    public Movie(){
    }
    
    public Movie(int id, String title, String picturePath, String description, LocalDateTime releaseDate) {
        this.id = id;
        this.title = title;
        this.picturePath = picturePath;
        this.description = description;
        this.releaseDate = releaseDate;
    }
    
    public Movie(String title, String picturePath, String description, LocalDateTime releaseDate) {

        this.title = title;
        this.picturePath = picturePath;
        this.description = description;
        this.releaseDate = releaseDate;
    }
    
    public Movie(int id, String title, String picturePath, String description, LocalDateTime releaseDate,
                 List<Director> directors, List<Actor> actors, List<Genre> genres) {
        this.id = id;
        this.title = title;
        this.picturePath = picturePath;
        this.description = description;
        this.releaseDate = releaseDate;
        this.directors = directors;
        this.actors = actors;
        this.genres = genres;
    }
    
        public Movie(String title, String picturePath, String description, LocalDateTime releaseDate,
                 List<Director> directors, List<Actor> actors, List<Genre> genres) {

        this.title = title;
        this.picturePath = picturePath;
        this.description = description;
        this.releaseDate = releaseDate;
        this.directors = directors;
        this.actors = actors;
        this.genres = genres;
    }
    
    public Movie(List<Director> directors, List<Actor> actors, List<Genre> genres){
        this.directors = directors;
        this.actors = actors;
        this.genres = genres;        
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPicturePath() {
        return picturePath;
    }

    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getPublishedDate() {
        return releaseDate;
    }

    public void setPublishedDate(LocalDateTime releaseDate) {
        this.releaseDate = releaseDate;
    }

    
    public List<Director> getDirectors() {
        return directors;
    }

    public void setDirectors(List<Director> directors) {
        this.directors = directors;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    
    
    
    @Override
    public String toString() {
        return "Movie{" + "id=" + id + ", title=" + title + ", picturePath=" + picturePath + ", description=" + description + ", publishedDate=" + releaseDate + '}';
    }

    
    
}
