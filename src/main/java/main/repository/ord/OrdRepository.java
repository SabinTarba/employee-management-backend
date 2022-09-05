package main.repository.ord;


import main.model.entities.Ord;
import main.model.OrderInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface OrdRepository extends JpaRepository<Ord, Long> {

    @Query(value = "SELECT * FROM order_info$v", nativeQuery = true)
    List<OrderInfo> getOrdersInfo();

    @Transactional
    @Modifying
    @Query(value = "UPDATE ord$ SET status = 'P' WHERE ord = :id", nativeQuery = true)
    void processOrder(@Param("id") Long id);


    @Transactional
    @Modifying
    @Query(value = "UPDATE ord$ SET status = 'R' WHERE ord = :id", nativeQuery = true)
    void confirmOrder(@Param("id") Long id);

    @Query(value = "SELECT app_usage#.get_order_price(pi_ord => :ord) AS price FROM dual", nativeQuery = true)
    Float getOrderPrice(@Param("ord") Long ord);
}
