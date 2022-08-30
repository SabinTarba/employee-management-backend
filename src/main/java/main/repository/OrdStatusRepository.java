package main.repository;

import main.model.OrdStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdStatusRepository extends JpaRepository<OrdStatus, String> {
}
