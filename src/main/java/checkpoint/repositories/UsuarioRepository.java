package checkpoint.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import checkpoint.entities.UsuarioEntity;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {

	UsuarioEntity findByEmail(String email);

	List<UsuarioEntity> findByCpf(String cpf);



}
