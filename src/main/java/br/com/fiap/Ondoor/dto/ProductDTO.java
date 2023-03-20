package br.com.fiap.Ondoor.dto;
import br.com.fiap.Ondoor.entities.Product;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class ProductDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private String image;

    private Double pricePerUnit;

    private Integer quantity = 0;

    @ManyToOne
    private CategoryDTO categoryDTO;

    @ManyToOne
    private RestaurantDTO restaurantDTO;

    @ManyToMany(mappedBy = "products")
    private List<OrderDTO> orders;

    public ProductDTO() {}

    public ProductDTO(Product product){
        id = product.getId();
        name = product.getName();
        description = product.getDescription();
        pricePerUnit = product.getPricePerUnit();
        quantity = product.getQuantity();
    }

    // getters and setters
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Double getPricePerUnit() {
        return pricePerUnit;
    }

    public void setPricePerUnit(Double pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public CategoryDTO getCategory() {
        return categoryDTO;
    }

    public void setCategory(CategoryDTO categoryDTO) {
        this.categoryDTO = categoryDTO;
    }

    public RestaurantDTO getRestaurant() {
        return restaurantDTO;
    }

    public void setRestaurant(RestaurantDTO restaurantDTO) {
        this.restaurantDTO = restaurantDTO;
    }

    public List<OrderDTO> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderDTO> orders) {
        this.orders = orders;
    }
}
