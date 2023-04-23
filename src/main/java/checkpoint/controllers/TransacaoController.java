package checkpoint.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import checkpoint.entities.PixEntity;
import checkpoint.entities.UsuarioEntity;
import checkpoint.enums.TipoChave;
import checkpoint.repositories.PixRepository;
import checkpoint.repositories.UsuarioRepository;

@RestController
@RequestMapping("/api/v1/transacao")
public class TransacaoController {
	@Service
	public class PixService {

	    @Autowired
	    private UsuarioRepository userRepository;

//	    @Autowired
//	    private PixRepository pixRepository;
//
//	    public ResponseEntity<PixEntity>enviarPix(@RequestBody PixEntity chavePix, @PathVariable Long id) {
//	        // Busca o usuário remetente pelo id
//	    	UsuarioEntity buscaUser= 
//	        //.orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado"));
//
//	        // Verifica se o usuário remetente tem saldo suficiente para enviar o Pix
//	        if (remetente.getSaldo() < valor) {
//	            throw new RuntimeException("Saldo insuficiente");
//	        }

	        // Busca o usuário destinatário pelo Pix
	        PixEntity pixDestinatario = PixRepository.findByValorAndTipo(chavePixDestinatario, TipoChave.CPF).orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado"));

	        // Verifica se o usuário destinatário está ativo
	        if (!pixDestinatario.getUsuario().isAtivo()) {
	            throw new RuntimeException("Usuário destinatário inativo");
	        }

	        // Subtrai o valor do remetente e adiciona ao destinatário
	        remetente.setSaldo(remetente.getSaldo() - valor);
	        pixDestinatario.getUsuario().setSaldo(pixDestinatario.getUsuario().getSaldo() + valor);

	        // Salva as alterações nos usuários
	        userRepository.save(remetente);
	        userRepository.save(pixDestinatario.getUsuario());
	    }
	}

}
