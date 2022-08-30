package main.repository.ord;

import main.model.entities.OrdStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdStatusRepository extends JpaRepository<OrdStatus, String> {
}
