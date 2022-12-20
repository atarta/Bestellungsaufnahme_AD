package htl.steyr.bestellungsaufnahme_ad.application.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import java.util.Set;

@EnableAutoConfiguration
@Entity
@Table(name = "ordering_product")
public class Ordering_Product {
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

    @Column(name = "product_price", nullable = false)
    private float product_price;

    @OneToMany(mappedBy = "ordering_product", fetch = FetchType.LAZY)
    Set<Ordering_Product_Ingredients> orderingProduct_ingredients;



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

    public float getProduct_price() {
        return product_price;
    }

    public void setProduct_price(float product_price) {
        this.product_price = product_price;
    }

    public Set<Ordering_Product_Ingredients> getOrderingProduct_ingredients() {
        return orderingProduct_ingredients;
    }

    public void setOrderingProduct_ingredients(Set<Ordering_Product_Ingredients> orderingProduct_ingredients) {
        this.orderingProduct_ingredients = orderingProduct_ingredients;
    }
}
