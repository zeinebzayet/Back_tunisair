package Tunisair.repository;

import Tunisair.entity.Avion;
import Tunisair.entity.EntrepriseRestauration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntrepriseRepository extends JpaRepository<EntrepriseRestauration, Long> {
}
