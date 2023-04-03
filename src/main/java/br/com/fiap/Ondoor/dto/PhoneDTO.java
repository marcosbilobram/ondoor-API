package br.com.fiap.Ondoor.dto;

import br.com.fiap.Ondoor.entities.Phone;
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
public class PhoneDTO {

    private Long id;
    private Integer DDD;
    private Integer DDI;
    private String number;

    public PhoneDTO(Phone phone) {
        this.id = phone.getId();
        this.DDD = phone.getDDD();
        this.DDI = phone.getDDI();
        this.number = phone.getNumber();
    }
}