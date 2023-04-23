package checkpoint.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import checkpoint.dtos.UsuarioDTO;
import checkpoint.entities.UsuarioEntity;
import checkpoint.exception.CpfJaUtilizadoException;
import checkpoint.exception.FormatoInvalidoException;
import checkpoint.repositories.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	public List<UsuarioDTO> findAll() {
		List<UsuarioEntity> usuario = usuarioRepository.findAll();
		return usuario.stream().map(user -> new UsuarioDTO(user)).collect(Collectors.toList());
	}

	public Optional<UsuarioEntity> findById(Long id) {
		return usuarioRepository.findById(id);
	}

	public UsuarioEntity inserirUsuario(UsuarioEntity user) throws CpfJaUtilizadoException {

		String cpf = user.getCpf();
		String email = user.getEmail();

		validarCpf(cpf);
		validarEmail(email);

		UsuarioEntity usuarioExistente = usuarioRepository.findByCpf(cpf);

		if (usuarioExistente != null) {
			throw new CpfJaUtilizadoException("O CPF " + cpf + " já está sendo utilizado");
		}

		return usuarioRepository.save(user);

	}

	private void validarCpf(String cpf) throws FormatoInvalidoException {
		String regex = "[0-9]{3}\\.[0-9]{3}\\.[0-9]{3}-[0-9]{2}";
		if (!cpf.matches(regex)) {
			throw new FormatoInvalidoException("CPF em formato inválido");
		}
	}

	private void validarEmail(String email) throws FormatoInvalidoException {
		EmailValidator validator = EmailValidator.getInstance();
		if (!validator.isValid(email)) {
			throw new FormatoInvalidoException("Email em formato inválido");
		}
	}

	public UsuarioEntity atualizarUsuario(UsuarioEntity usuario, Long id) {
		return usuarioRepository.findById(id).map(u -> {
			u.setNome(usuario.getNome());
			return usuarioRepository.save(u);
		}).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
	}

	public void delete(Long id) {
		if (usuarioRepository.findById(id).isPresent()) {
			usuarioRepository.deleteById(id);
		} else {
			throw new IllegalArgumentException("usuario não foi removido, id não encontrado!");
		}
		
	}

}
