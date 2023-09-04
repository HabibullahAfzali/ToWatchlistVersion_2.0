package com.MovieSeries.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Table;

@Entity
@Table(name = "Films")
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false, unique = true, length = 50)
    private String title;

    @Column(name = "date", nullable = false, length = 50)
    private int date;

    @Column(name = "genre", nullable = false)
    private String genre;

    @Column(name = "WhereToWatch", nullable = false)
    private String WhereToWatch;

    public Film(Long id, String title, int date, String genre, String WhereToWatch) {
        super();
        this.id = id;
        this.title = title;
        this.date = date;
        this.genre = genre;
        this.WhereToWatch = WhereToWatch;

    }

    public Film() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getWhereToWatch() {
        return WhereToWatch;
    }

    public void setWhereToWatch(String WhereToWatch) {
        this.WhereToWatch = WhereToWatch;
    }

}