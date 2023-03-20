package br.com.fiap.Ondoor.dto;

import jakarta.persistence.*;

import java.util.Calendar;
import java.util.List;

@Entity
public class RatingDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer stars;

    private String comment;

    @ElementCollection
    private List<String> answers;

    @Temporal(TemporalType.TIMESTAMP)
    private Calendar date;

    @ManyToOne
    private ClientDTO clientDTO;

    @ManyToOne
    private RestaurantDTO restaurantDTO;

    public RatingDTO() {}

    public RatingDTO(Long id, Integer stars, String comment, List<String> answers, Calendar date, ClientDTO clientDTO, RestaurantDTO restaurantDTO) {
        this.id = id;
        this.stars = stars;
        this.comment = comment;
        this.answers = answers;
        this.date = date;
        this.clientDTO = clientDTO;
        this.restaurantDTO = restaurantDTO;
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

    public ClientDTO getClient() {
        return clientDTO;
    }

    public void setClient(ClientDTO clientDTO) {
        this.clientDTO = clientDTO;
    }

    public RestaurantDTO getRestaurant() {
        return restaurantDTO;
    }

    public void setRestaurant(RestaurantDTO restaurantDTO) {
        this.restaurantDTO = restaurantDTO;
    }
}
