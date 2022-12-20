package htl.steyr.bestellungsaufnahme_ad.application.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import java.util.Set;

@EnableAutoConfiguration
@Entity
@Table(name = "orderingProduct")
public class OrderingProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orderingId")
    Ordering ordering;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "productId")
    Product product;

    @Column(name = "quantitiy", nullable = false)
    private long quantitiy;

    @Column(name = "productPrice", nullable = false)
    private float productPrice;

    @OneToMany(mappedBy = "orderingProduct", fetch = FetchType.LAZY)
    Set<OrderingProductIngredients> orderingProductIngredients;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Ordering getOrdering() {
        return ordering;
    }

    public void setOrdering(Ordering ordering) {
        this.ordering = ordering;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public long getQuantitiy() {
        return quantitiy;
    }

    public void setQuantitiy(long quantitiy) {
        this.quantitiy = quantitiy;
    }

    public float getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(float productPrice) {
        this.productPrice = productPrice;
    }

    public Set<OrderingProductIngredients> getOrderingProductIngredients() {
        return orderingProductIngredients;
    }

    public void setOrderingProductIngredients(Set<OrderingProductIngredients> orderingProductIngredients) {
        this.orderingProductIngredients = orderingProductIngredients;
    }
}
