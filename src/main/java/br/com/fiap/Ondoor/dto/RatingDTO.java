package br.com.fiap.Ondoor.dto;

import br.com.fiap.Ondoor.entities.Client;
import br.com.fiap.Ondoor.entities.Rating;
import br.com.fiap.Ondoor.entities.Restaurant;

import java.util.Calendar;
import java.util.List;

public class RatingDTO {

    private Long id;

    private Integer stars;

    private String comment;

    private List<String> answers;

    private Calendar date;

    private Client client;

    private Restaurant restaurant;

    public RatingDTO() {}

    public RatingDTO(Rating rating) {
        this.id = rating.getId();
        this.stars = rating.getStars();
        this.comment = rating.getComment();
        this.answers = rating.getAnswers();
        this.date = rating.getDate();
        this.client = rating.getClient();
        this.restaurant = rating.getRestaurant();
    }

    // getters and setters

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
