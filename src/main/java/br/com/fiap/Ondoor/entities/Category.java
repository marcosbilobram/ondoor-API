package br.com.fiap.Ondoor.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Table(name = "tb_ond_category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "tb_prod_categ",
            joinColumns =
            @JoinColumn(
                    name = "prod_id",
                    referencedColumnName = "id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "categ_id",
                    referencedColumnName = "id"
            )
    )
    private List<Product> productList;

}
