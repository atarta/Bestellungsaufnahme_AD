package htl.steyr.bestellungsaufnahme_ad.application.model;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Ordering_Product_IngredientsRepository extends JpaRepository<Ordering_Product_Ingredients, Long> {
}
