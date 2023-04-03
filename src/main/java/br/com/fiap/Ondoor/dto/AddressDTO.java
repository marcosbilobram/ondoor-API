package br.com.fiap.Ondoor.dto;

import br.com.fiap.Ondoor.entities.Address;
import br.com.fiap.Ondoor.entities.Client;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class AddressDTO {

    private Long id;
    private String addressType;
    private String street;
    private int number;
    private String complement;
    private String neighborhood;
    private String city;
    private String state;
    private String zipCode;
    private String country;

    private Client client;

    public AddressDTO(Address address){
        id = address.getId();
        addressType = getAddressType();
        street = getAddressType();
        number = getNumber();
        complement = getAddressType();
        neighborhood = getAddressType();
        city = getAddressType();
        state = getAddressType();
        zipCode = getAddressType();
        country = getAddressType();
    }
}