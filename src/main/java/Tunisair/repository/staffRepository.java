package Tunisair.repository;

import Tunisair.entity.Avion;
import Tunisair.entity.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface staffRepository extends JpaRepository<Staff, Long> {
}
