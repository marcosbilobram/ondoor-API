package br.com.fiap.Ondoor.dto;

import br.com.fiap.Ondoor.entities.Client;
import br.com.fiap.Ondoor.entities.Rating;
import br.com.fiap.Ondoor.entities.Restaurant;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Calendar;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class RatingDTO {

    private Long id;

    private Integer stars;

    private String comment;

    private List<String> answers;

    private Calendar date;

    private Client client;

    private Restaurant restaurant;

    public RatingDTO(Rating rating) {
        this.id = rating.getId();
        this.stars = rating.getStars();
        this.comment = rating.getComment();
        this.answers = rating.getAnswers();
        this.date = rating.getDate();
        this.client = rating.getClient();
        this.restaurant = rating.getRestaurant();
    }
}
