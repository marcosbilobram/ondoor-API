package br.com.fiap.Ondoor.dto;

import br.com.fiap.Ondoor.entities.Category;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class CategoryDTO {

    private Long id;
    private String name;
    private String description;

    public CategoryDTO() {}

    public CategoryDTO(Category category){
        id = category.getId();
        name = getName();
        description = getDescription();
    }

    //getters and setters

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
}