package it.lucianofilippucci.zgest.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Phone {
    private Long id;
    private String number;

    public Phone() {

    }

    public Phone(String number) {
        this.number = number;
    }

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return getNumber();
    }

    public void setNumber(String number) {
        this.number = number;
    }
}