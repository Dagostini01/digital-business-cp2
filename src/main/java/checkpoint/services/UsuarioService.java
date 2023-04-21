package checkpoint.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import checkpoint.entities.UsuarioEntity;
import checkpoint.repositories.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	public List<UsuarioEntity> findAll() {
		return usuarioRepository.findAll();
	}

}
