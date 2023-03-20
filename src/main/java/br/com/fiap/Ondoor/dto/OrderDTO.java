package br.com.fiap.Ondoor.dto;

import jakarta.persistence.*;

import java.util.Calendar;
import java.util.List;

@Entity
public class OrderDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Double totalValue;

    @Temporal(TemporalType.TIMESTAMP)
    private Calendar date;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<ProductDTO> productDTOS;

    @OneToOne(cascade = CascadeType.ALL)
    private AddressDTO deliveryAddressDTO;

    @ManyToOne
    private ClientDTO clientDTO;

    @ManyToOne
    private RestaurantDTO restaurantDTO;

    private String status;

    public OrderDTO() {}

    public OrderDTO(Integer id, Double totalValue, Calendar date, List<ProductDTO> productDTOS, AddressDTO deliveryAddressDTO, ClientDTO clientDTO, RestaurantDTO restaurantDTO, String status) {
        this.id = id;
        this.totalValue = totalValue;
        this.date = date;
        this.productDTOS = productDTOS;
        this.deliveryAddressDTO = deliveryAddressDTO;
        this.clientDTO = clientDTO;
        this.restaurantDTO = restaurantDTO;
        this.status = status;
    }

    // getters and setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(Double totalValue) {
        this.totalValue = totalValue;
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public List<ProductDTO> getProducts() {
        return productDTOS;
    }

    public void setProducts(List<ProductDTO> productDTOS) {
        this.productDTOS = productDTOS;
    }

    public AddressDTO getDeliveryAddress() {
        return deliveryAddressDTO;
    }

    public void setDeliveryAddress(AddressDTO deliveryAddressDTO) {
        this.deliveryAddressDTO = deliveryAddressDTO;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}