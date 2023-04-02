package edu.school21.cinema.models;

import javax.persistence.*;

@Entity
@Table(name = "films")
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String yearOfRelease;
    private String ageRestrictions;
    private String description;
    private String posterUrl;

    public Film() {
    }

    public Film(String name, String yearOfRelease, String ageRestrictions, String description) {
        this.name = name;
        this.yearOfRelease = yearOfRelease;
        this.ageRestrictions = ageRestrictions;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYearOfRelease() {
        return yearOfRelease;
    }

    public void setYearOfRelease(String yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }

    public String getAgeRestrictions() {
        return ageRestrictions;
    }

    public void setAgeRestrictions(String ageRestrictions) {
        this.ageRestrictions = ageRestrictions;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPosterUrl() {
        return posterUrl;
    }

    public void setPosterUrl(String posterUrl) {
        this.posterUrl = posterUrl;
    }
}
