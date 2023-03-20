package br.com.fiap.Ondoor.entities;

import jakarta.persistence.Embeddable;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Embeddable
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer DDD;
    private Integer DDI;
    private String number;

    public Phone(){}

    public Phone(Integer DDD, Integer DDI, String number) {
        this.DDD = DDD;
        this.DDI = DDI;
        this.number = number;
    }

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
