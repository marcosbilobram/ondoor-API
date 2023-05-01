package br.com.fiap.Ondoor.dto;

import br.com.fiap.Ondoor.entities.Category;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class CategoryDTO {

    private Long id;
    private String name;
    private String description;

    public CategoryDTO(Category category){
        id = category.getId();
        name = category.getName();
        description = category.getDescription();
    }
}