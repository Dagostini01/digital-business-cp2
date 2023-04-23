package checkpoint.controllers;

import checkpoint.entities.TransacaoEntity;
import checkpoint.services.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/transacoes")
public class TransacaoController {

    @Autowired
    private TransacaoService transacaoService;

    @GetMapping
    public ResponseEntity<List<TransacaoEntity>> findAll() {
        return ResponseEntity.ok(transacaoService.findAll());
    }


    @PostMapping
    public ResponseEntity<String> realizarTransacao(@RequestBody TransacaoEntity transacao) {
        try {
            transacaoService.realizarTransacao(transacao);
            return ResponseEntity.created(URI.create("/transacoes")).body("Transação cadastrada");
        } catch (Exception e) {
            return ResponseEntity.unprocessableEntity().body(e.getMessage());
        }

    }

    @GetMapping("/ultimos7dias")
    public ResponseEntity<TransacaoEntity> listarUltmiosSeteDias() {
        List<TransacaoEntity> transacoes = transacaoService.listarTransacoesUltimos7Dias();
        return ResponseEntity.ok().body((TransacaoEntity) transacoes);
    }
}
