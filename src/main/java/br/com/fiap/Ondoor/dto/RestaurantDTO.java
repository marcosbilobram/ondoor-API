package br.com.fiap.Ondoor.dto;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class RestaurantDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String restaurantName;

    @Column
    private String logo;

    @Embedded
    private PhoneDTO phoneDTO;

    @Embedded
    private AddressDTO addressDTO;

    @OneToMany(mappedBy = "restaurant")
    private List<OrderDTO> orders;

    @OneToMany(mappedBy = "restaurant")
    private List<RatingDTO> ratings;

    @OneToMany(mappedBy = "restaurant")
    private List<ProductDTO> products;

    public RestaurantDTO() {}

    public RestaurantDTO(Long id, String restaurantName, String logo, PhoneDTO phoneDTO, AddressDTO addressDTO, List<OrderDTO> orders, List<RatingDTO> ratings, List<ProductDTO> products) {
        this.id = id;
        this.restaurantName = restaurantName;
        this.logo = logo;
        this.phoneDTO = phoneDTO;
        this.addressDTO = addressDTO;
        this.orders = orders;
        this.ratings = ratings;
        this.products = products;
    }

    // Getters e Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public PhoneDTO getPhone() {
        return phoneDTO;
    }

    public void setPhone(PhoneDTO phoneDTO) {
        this.phoneDTO = phoneDTO;
    }

    public AddressDTO getAddress() {
        return addressDTO;
    }

    public void setAddress(AddressDTO addressDTO) {
        this.addressDTO = addressDTO;
    }

    public List<OrderDTO> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderDTO> orders) {
        this.orders = orders;
    }

    public List<RatingDTO> getRatings() {
        return ratings;
    }

    public void setRatings(List<RatingDTO> ratings) {
        this.ratings = ratings;
    }

    public List<ProductDTO> getProducts() {
        return products;
    }

    public void setProducts(List<ProductDTO> products) {
        this.products = products;
    }
}