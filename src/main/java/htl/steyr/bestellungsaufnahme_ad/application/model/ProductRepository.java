package htl.steyr.bestellungsaufnahme_ad.application.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findById(int productId);

//    @Transactional
//    @Modifying
//    @Query("""
//            update Product p set p.category = ?1, p.name = ?2, p.price = ?3
//            where p.id = ?4""")
//    int update(Category category, String name, float price, Long id);


}
