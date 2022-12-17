package htl.steyr.bestellungsaufnahme_ad.application.model;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderingRepository extends JpaRepository<Ordering, Long> {
}
