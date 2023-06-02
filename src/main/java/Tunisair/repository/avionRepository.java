package Tunisair.repository;

import Tunisair.entity.Avion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface avionRepository extends JpaRepository<Avion, Long> {
}
