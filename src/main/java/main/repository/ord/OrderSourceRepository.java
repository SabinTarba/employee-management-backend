package main.repository.ord;

import main.model.entities.OrderOriginSource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderSourceRepository extends JpaRepository<OrderOriginSource, Long> {
}
