package htl.steyr.bestellungsaufnahme_ad.application.model;

import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import java.time.LocalDate;
import java.util.Set;

@EnableAutoConfiguration
@Entity
@Table(name = "order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;


    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY)
    Set<Order_Product> order_products;

    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY)
    Set<Order_Ingredients> order_ingredients;


    @Column(name = "delivery", nullable = false)
    private boolean delivery;

    @Column(name = "timestamp", nullable = false)
    private LocalDate timestamp;

    @Column(name = "confirmed_time", nullable = false)
    private LocalDate confirmed_time;

    @Column(name = "price", nullable = false)
    private Float price;

    public Set<Order_Product> getOrder_products() {
        return order_products;
    }

    public void setOrder_products(Set<Order_Product> order_products) {
        this.order_products = order_products;
    }

    public Set<Order_Ingredients> getOrder_ingredients() {
        return order_ingredients;
    }

    public void setOrder_ingredients(Set<Order_Ingredients> order_ingredients) {
        this.order_ingredients = order_ingredients;
    }

    public boolean isDelivery() {
        return delivery;
    }

    public void setDelivery(boolean delivery) {
        this.delivery = delivery;
    }

    public LocalDate getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDate timestamp) {
        this.timestamp = timestamp;
    }

    public LocalDate getConfirmed_time() {
        return confirmed_time;
    }

    public void setConfirmed_time(LocalDate confirmed_time) {
        this.confirmed_time = confirmed_time;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

