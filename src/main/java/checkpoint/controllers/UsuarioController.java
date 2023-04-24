package checkpoint.controllers;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import checkpoint.dtos.UsuarioDTO;
import checkpoint.entities.UsuarioEntity;
import checkpoint.services.UsuarioService;

@RestController
@RequestMapping("/api/v1/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioService usrService;

	@GetMapping
	public ResponseEntity<List<UsuarioDTO>> findAll() {
		return ResponseEntity.ok(usrService.findAll());
	}

	@PostMapping
	public ResponseEntity<String> inserirUsuario(@RequestBody UsuarioEntity user) {
		try {
			usrService.inserirUsuario(user);
			return ResponseEntity.created(URI.create("/usuarios")).body("usuario criado!");
		} catch (Exception e) {
			return ResponseEntity.unprocessableEntity().body(e.getMessage());
		}

	}

	@GetMapping("/{id}")
	public ResponseEntity<UsuarioEntity> one(@PathVariable Long id) {
		Optional<UsuarioEntity> usuario = usrService.findById(id);
		return usuario.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}

	@PutMapping("/{id}")
	public ResponseEntity<UsuarioEntity> replaceUsuarioEntity(@RequestBody UsuarioEntity newUsuarioEntity,
			@PathVariable Long id) {
		UsuarioEntity novoUsuario = usrService.atualizarUsuario(newUsuarioEntity, id);
		if (novoUsuario != null) {
			return ResponseEntity.ok(novoUsuario);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteUsuarioEntity(@PathVariable Long id) {
		try {
			usrService.delete(id);
			return ResponseEntity.ok("usuario removido com sucesso!");
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("usuario não foi removido, id não encontrado!");
		}

	}

}
