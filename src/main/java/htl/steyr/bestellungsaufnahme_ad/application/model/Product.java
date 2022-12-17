package htl.steyr.bestellungsaufnahme_ad.application.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import java.util.Set;

@EnableAutoConfiguration
@Entity
@Table(name = "produkt")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    Set<Ordering_Product> ordering_products;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoryId")
    Category category;

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    Set<Product_Ingredients> product_ingredients;


    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "price", nullable = false)
    private float price;

    public Set<Product_Ingredients> getProduct_ingredients() {
        return product_ingredients;
    }

    public void setProduct_ingredients(Set<Product_Ingredients> product_ingredients) {
        this.product_ingredients = product_ingredients;
    }

    public Set<Ordering_Product> getOrdering_products() {
        return ordering_products;
    }

    public void setOrdering_products(Set<Ordering_Product> ordering_products) {
        this.ordering_products = ordering_products;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
