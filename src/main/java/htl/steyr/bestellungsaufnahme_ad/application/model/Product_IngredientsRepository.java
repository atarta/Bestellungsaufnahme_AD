package htl.steyr.bestellungsaufnahme_ad.application.model;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Product_IngredientsRepository extends JpaRepository<Product_Ingredients, Long> {
}
