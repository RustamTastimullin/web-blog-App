package ru.springapp.blog.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Zakupki {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String inNumber, outNumber, link, price, status;

    public Zakupki(String inNumber, String outNumber, String link, String price, String status) {
        this.inNumber = inNumber;
        this.outNumber = outNumber;
        this.link = link;
        this.price = price;
        this.status = status;
    }

    public Zakupki() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInNumber() {
        return inNumber;
    }

    public void setInNumber(String inNumber) {
        this.inNumber = inNumber;
    }

    public String getOutNumber() {
        return outNumber;
    }

    public void setOutNumber(String outNumber) {
        this.outNumber = outNumber;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
