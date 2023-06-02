package Tunisair.repository;

import Tunisair.entity.Aeroport;
import Tunisair.entity.Avion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface aeroportsRepository extends JpaRepository<Aeroport, Long> {
}
