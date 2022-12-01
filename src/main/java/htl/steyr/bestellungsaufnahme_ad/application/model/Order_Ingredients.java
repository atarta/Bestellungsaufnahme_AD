package htl.steyr.bestellungsaufnahme_ad.application.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

@EnableAutoConfiguration
@Entity
@Table(name = "order_ingredients")
public class Order_Ingredients {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;


    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orderId")
    Order order;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ingredientsID")
    Ingredient ingredient;

    @Column(name = "ontop", nullable = false)
    private boolean ontop;

    @Column(name = "quantitiy", nullable = false)
    private long quantitiy;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
