package htl.steyr.bestellungsaufnahme_ad.application.model;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Order_IngredientsRepository extends JpaRepository<Order_Ingredients, Long> {
}
