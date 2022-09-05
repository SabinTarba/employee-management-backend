package main.repository.ord;

import main.model.OrderlnInfo;
import main.model.entities.OrdLn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrdLnRepository extends JpaRepository<OrdLn, Long> {

    @Query(value = "SELECT ln.ln AS line, p.descr AS description, ROUND(ln.price, 2) AS price, ROUND(ln.qty, 2) AS quantity FROM ordln$ ln JOIN products$ p ON ln.product_id = p.id WHERE ord = :ord ORDER BY ln ASC", nativeQuery = true)
    List<OrderlnInfo> getOrderLines(@Param("ord") Long ord);

}
