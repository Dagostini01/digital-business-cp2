package checkpoint.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import checkpoint.entities.ProdutoEntity;
import checkpoint.services.ProdutoService;

@RestController
@RequestMapping("/api/v1/produtos")
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;

	@GetMapping
	ResponseEntity<List<ProdutoEntity>> getProducts() {
		return ResponseEntity.ok(produtoService.getProduts());
	}

	@PostMapping
	public ProdutoEntity inseririProduto(@RequestBody ProdutoEntity produto) {
		return produtoService.inserirProduto(produto);

	}

	@PutMapping("/{id}")
	public ResponseEntity<ProdutoEntity> alterarProduto(@RequestBody ProdutoEntity produtoAtualizado,
															  @PathVariable Long id) {

		ProdutoEntity novoProduto = produtoService.atualizarProduto(produtoAtualizado, id);
		if (novoProduto != null) {
			return ResponseEntity.ok(novoProduto);
		} else {
			return ResponseEntity.notFound().build();
		}

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deletarProduto(@PathVariable Long id) {
		try {
			produtoService.delete(id);
			return ResponseEntity.ok("Produto deletado com sucesso");
		} catch (Exception e){
			e.printStackTrace();
			return ResponseEntity.badRequest().body("Produto nao encontrado");
		}
	}

}