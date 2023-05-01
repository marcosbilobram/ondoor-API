package br.com.fiap.Ondoor.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Phone {

    @Column(nullable = false, length = 3)
    private Integer DDI;

    @Column(nullable = false, length = 2)
    private Integer DDD;

    @Column(nullable = false, length = 12)
    private String phoneNumber;
}
