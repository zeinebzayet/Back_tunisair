package Tunisair.repository;

import Tunisair.entity.Vol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface volRepository extends JpaRepository<Vol, Long>{

}
