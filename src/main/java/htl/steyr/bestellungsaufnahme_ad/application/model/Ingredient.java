package htl.steyr.bestellungsaufnahme_ad.application.model;

import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import java.util.Set;

@EnableAutoConfiguration
@Entity
@Table(name = "ingredient")
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToMany(mappedBy = "ingredient", fetch = FetchType.LAZY)
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
}
