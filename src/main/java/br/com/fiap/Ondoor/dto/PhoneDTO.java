package br.com.fiap.Ondoor.dto;

import br.com.fiap.Ondoor.entities.Phone;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class PhoneDTO {

    private Long id;
    private Integer DDD;
    private Integer DDI;
    private String number;

    public PhoneDTO() {}

    public PhoneDTO(Phone phone) {
        this.id = phone.getId();
        this.DDD = phone.getDDD();
        this.DDI = phone.getDDI();
        this.number = phone.getNumber();
    }

    // getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getDDD() {
        return DDD;
    }

    public void setDDD(Integer DDD) {
        this.DDD = DDD;
    }

    public Integer getDDI() {
        return DDI;
    }

    public void setDDI(Integer DDI) {
        this.DDI = DDI;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}