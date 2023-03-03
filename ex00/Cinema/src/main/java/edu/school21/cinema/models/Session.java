package edu.school21.cinema.models;

import javax.persistence.*;

@Entity
@Table(name = "sessions")
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "hall_id")
    private Hall hall;
    @ManyToOne
    @JoinColumn(name = "film_id")
    private Film film;
    private String time;
    private String ticketCost;

    public Hall getHall() {
        return hall;
    }

    public void setHall(Hall hall) {
        this.hall = hall;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public Session() {
    }

    public Session(Hall hall, Film film, String time, String ticketCost) {
        this.hall = hall;
        this.film = film;
        this.time = time;
        this.ticketCost = ticketCost;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTicketCost() {
        return ticketCost;
    }

    public void setTicketCost(String ticketCost) {
        this.ticketCost = ticketCost;
    }
}
