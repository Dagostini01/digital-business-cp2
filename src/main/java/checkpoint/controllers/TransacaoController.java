package checkpoint.controllers;

import java.util.Calendar;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import checkpoint.entities.PixEntity;
import checkpoint.entities.TransacaoEntity;
import checkpoint.entities.UsuarioEntity;
import checkpoint.enums.StatusTransacao;
import checkpoint.enums.TipoChave;
import checkpoint.repositories.PixRepository;
import checkpoint.repositories.UsuarioRepository;
import checkpoint.services.UsuarioService;

@RestController
@RequestMapping("/api/v1/transacao")
public class TransacaoController {
	
	@Autowired
	private UsuarioService usrService;

	@Service
	public class PixService {

		@PostMapping("/pix")
		public TransacaoEntity fazerPix(@RequestParam Long idDebitor, @RequestParam String chavePix, @RequestParam Double valor) {
		    // Verifica se ambos os usuários estão ativos na base de dados
		    Optional<UsuarioEntity> debitor = usrService.findById(idDebitor);
		    UsuarioEntity creditor = (chavePix);
		    if (!debitor.isAtivo() || !creditor.isAtivo()) {
		        throw new RuntimeException("Usuário não encontrado ou inativo na base de dados");
		    }
		    
		    // Verifica se o saldo do usuário de débito é suficiente para a transação
		    if (debitor.getSaldo() < valor) {
		        throw new RuntimeException("Saldo insuficiente");
		    }
		    
		    // Verifica se a chave PIX fornecida pelo usuário existe na base de dados
		    PixEntity pix = pixService.getPixByValor(chavePix);
		    if (pix == null) {
		        throw new RuntimeException("Chave PIX não encontrada na base de dados");
		    }
		    
		    // Subtrai o valor da transação do saldo do usuário de débito
		    debitor.setSaldo(debitor.getSaldo() - valor);
		    UsuarioService.salvarUsuario(debitor);
		    
		    // Adiciona o valor da transação ao saldo do usuário que possui a chave PIX
		    creditor.setSaldo(creditor.getSaldo() + valor);
		    UsuarioService.salvarUsuario(creditor);
		    
		    // Cria uma nova transação com os detalhes fornecidos
		    TransacaoEntity transacao = new TransacaoEntity();
		    transacao.setStatus(StatusTransacao.SUCESSO);
		    transacao.setHoraTranscao(Calendar.getInstance());
		    transacao.setDebitor(debitor);
		    transacao.setCh


}
