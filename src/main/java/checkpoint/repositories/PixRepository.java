package checkpoint.repositories;

import checkpoint.entities.PixEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PixRepository extends JpaRepository<PixEntity, Long> {
}
