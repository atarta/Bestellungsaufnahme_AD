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


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

