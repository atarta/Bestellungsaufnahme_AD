package htl.steyr.bestellungsaufnahme_ad.application.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import java.time.LocalDate;
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
    Set<Ordering_Product> ordering_products;

    @Column(name = "delivery")
    private boolean delivery;

    @Column(name = "timestamp")
    private LocalDate timestamp;

    @Column(name = "confirmed_time")
    private LocalDate confirmed_time;

    @Column(name = "price", nullable = false)
    private Float price;

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
}

