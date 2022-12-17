package htl.steyr.bestellungsaufnahme_ad.application.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

@EnableAutoConfiguration
@Entity
@Table(name = "orderingProduct_ingredients")
public class Ordering_Product_Ingredients {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;


    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ordering_product_Id")
    Ordering_Product ordering_product;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ingredientsId")
    Ingredient ingredient;

    @Column(name = "ontop", nullable = false)
    private boolean ontop;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Ordering_Product getOrdering_product() {
        return ordering_product;
    }

    public void setOrdering_product(Ordering_Product ordering_product) {
        this.ordering_product = ordering_product;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public boolean isOntop() {
        return ontop;
    }

    public void setOntop(boolean ontop) {
        this.ontop = ontop;
    }
}
