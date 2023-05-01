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
public class Address {

    @Column(length = 20)
    private String addressType;

    @Column(length = 25, nullable = false)
    private String street;

    @Column(length = 6, nullable = false)
    private int addressNumber;

    @Column(length = 25)
    private String complement;

    @Column(length = 30)
    private String neighborhood;

    @Column(length = 20, nullable = false)
    private String city;

    @Column(length = 25, nullable = false)
    private String state;

    @Column(length = 20, nullable = false)
    private String zipCode;

    @Column(length = 20)
    private String country;
}
