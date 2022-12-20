package htl.steyr.bestellungsaufnahme_ad.application.model;

import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

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
    Set<OrderingProduct> orderingProductsOrdering;

    @Column(name = "delivery", nullable = false)
    private boolean delivery;

    @Column(name = "timestamp")
    private LocalDateTime timestamp;

    @Column(name = "confirmedTime")
    private LocalDateTime confirmedTime;

    @Column(name = "price", nullable = false)
    private Float price;

    public Set<OrderingProduct> getOrderingProductsOrdering() {
        return orderingProductsOrdering;
    }

    public void setOrderingProductsOrdering(Set<OrderingProduct> orderingProducts) {
        this.orderingProductsOrdering = orderingProducts;
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

    public LocalDateTime getConfirmedTime() {
        return confirmedTime;
    }

    public void setConfirmedTime(LocalDateTime confirmedTime) {
        this.confirmedTime = confirmedTime;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}

