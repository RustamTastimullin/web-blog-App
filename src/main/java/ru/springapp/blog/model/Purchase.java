package ru.springapp.blog.model;

import javax.persistence.*;

@Entity
@Table(name = "purchase")
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "in_number")
    private String inNumber;

    @Column(name = "out_number")
    private String outNumber;

    @Column(name = "link")
    private String link;

    @Column(name = "price")
    private String price;

    @Column(name = "status")
    private String status;

    public Purchase() {
    }

    public Purchase(String inNumber, String outNumber, String link, String price, String status) {
        this.inNumber = inNumber;
        this.outNumber = outNumber;
        this.link = link;
        this.price = price;
        this.status = status;
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
