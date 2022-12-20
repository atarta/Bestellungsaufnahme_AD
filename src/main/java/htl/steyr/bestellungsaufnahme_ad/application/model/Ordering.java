package htl.steyr.bestellungsaufnahme_ad.application.model;

import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@EnableAutoConfiguration
@Entity
@Table(name = "ordering")
public class Ordering {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;


    @OneToMany(mappedBy = "ordering", fetch = FetchType.LAZY)
    Set<Ordering_Product> ordering_products_ordering;

    @Column(name = "delivery", nullable = false)
    private boolean delivery;

    @Column(name = "timestamp")
    private LocalDateTime timestamp;

    @Column(name = "confirmed_time")
    private LocalDateTime confirmed_time;

    @Column(name = "price", nullable = false)
    private Float price;

    public Set<Ordering_Product> getOrdering_products_ordering() {
        return ordering_products_ordering;
    }

    public void setOrdering_products_ordering(Set<Ordering_Product> ordering_products) {
        this.ordering_products_ordering = ordering_products;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isDelivery() {
        return delivery;
    }

    public void setDelivery(boolean delivery) {
        this.delivery = delivery;
    }

    public Boolean getDelivery() {
        return delivery;
    }


    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public LocalDateTime getConfirmed_time() {
        return confirmed_time;
    }

    public void setConfirmed_time(LocalDateTime confirmed_time) {
        this.confirmed_time = confirmed_time;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}

