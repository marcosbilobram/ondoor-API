package br.com.fiap.Ondoor.dto;

import br.com.fiap.Ondoor.entities.*;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

import java.util.List;
import java.util.Locale;

@Entity
public class ClientDTO extends User {

    private String clientName;

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    @OneToOne(cascade = CascadeType.ALL)
    private PhoneDTO phoneDTO;

    @OneToOne(cascade = CascadeType.ALL)
    private CartDTO cartDTO;

    @OneToMany(mappedBy = "client")
    private List<Order> orders;

    @OneToMany(mappedBy = "client")
    private List<Rating> ratings;
    private AddressDTO addressDTO;

    public ClientDTO() {}

    public ClientDTO(String clientName, Address address, PhoneDTO phoneDTO, CartDTO cartDTO, List<Order> orders, List<Rating> ratings, AddressDTO addressDTO) {
        this.clientName = clientName;
        this.address = address;
        this.phoneDTO = phoneDTO;
        this.cartDTO = cartDTO;
        this.orders = orders;
        this.ratings = ratings;
        this.addressDTO = addressDTO;
    }

    public ClientDTO(Long id, String userName, String email, String password, String clientName, Address address, PhoneDTO phoneDTO, CartDTO cartDTO, List<Order> orders, List<Rating> ratings, AddressDTO addressDTO) {
        super(id, userName, email, password);
        this.clientName = clientName;
        this.address = address;
        this.phoneDTO = phoneDTO;
        this.cartDTO = cartDTO;
        this.orders = orders;
        this.ratings = ratings;
        this.addressDTO = addressDTO;
    }

    public ClientDTO(Client client){
        clientName = client.getClientName();


    }

    // getters and setters

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public AddressDTO getAddress() {
        AddressDTO addressDTO = null;
        return addressDTO;
    }

    public void setAddress(AddressDTO addressDTO) {
        this.addressDTO = addressDTO;
    }

    public PhoneDTO getPhone() {
        return phoneDTO;
    }

    public void setPhone(PhoneDTO phoneDTO) {
        this.phoneDTO = phoneDTO;
    }

    public CartDTO getCart() {
        return cartDTO;
    }

    public void setCart(CartDTO cartDTO) {
        this.cartDTO = cartDTO;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }
}