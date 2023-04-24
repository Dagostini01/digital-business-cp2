package checkpoint.repositories;

import checkpoint.entities.SaldoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaldoRepository extends JpaRepository<SaldoEntity, Long> {
}
