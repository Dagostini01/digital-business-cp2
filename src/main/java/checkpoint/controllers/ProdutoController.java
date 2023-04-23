package checkpoint.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import checkpoint.entities.ProdutoEntity;
import checkpoint.services.ProdutoService;

@RestController
@RequestMapping("/api/v1/produtos")
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;

	@GetMapping("/produtos")
	ResponseEntity<List<ProdutoEntity>> getProducts() {
		return ResponseEntity.ok(produtoService.getProduts());
	}

	@PostMapping
	public ProdutoEntity inseririProduto(@RequestBody ProdutoEntity produto) {
		return produtoService.inserirProduto(produto);

	}

}