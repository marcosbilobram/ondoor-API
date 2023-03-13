package br.com.fiap.Ondoor.entities;

import java.util.Calendar;
import java.util.List;

//Embaddable
public class Rating {

    private Long id;
    private Integer stars;
    private String comment;
    private List<String> answers;
    private Calendar date;
    private Client client;
    private Restaurant restaurant;

    public Rating(){}

    public Rating(Long id, Integer stars, String comment, List<String> answers, Calendar date, Client client, Restaurant restaurant) {
        this.id = id;
        this.stars = stars;
        this.comment = comment;
        this.answers = answers;
        this.date = date;
        this.client = client;
        this.restaurant = restaurant;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getStars() {
        return stars;
    }

    public void setStars(Integer stars) {
        this.stars = stars;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public List<String> getAnswers() {
        return answers;
    }

    public void setAnswers(List<String> answers) {
        this.answers = answers;
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
}
