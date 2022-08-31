package main.repository.product;

import main.model.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Modifying
    @Transactional
    @Query(value = "UPDATE products$ SET active = :activeOption WHERE id = :prodId", nativeQuery = true)
    void toggleActive(@Param("prodId") Long id, @Param("activeOption") Boolean activeOption);
}
