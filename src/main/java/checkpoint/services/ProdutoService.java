package checkpoint.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import checkpoint.entities.ProdutoEntity;
import checkpoint.repositories.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;

	public List<ProdutoEntity> getProduts() {
		return produtoRepository.findAll();
	}
	
	public ProdutoEntity inserirProduto(ProdutoEntity produto) {
		return produtoRepository.save(produto);

	}

	public ProdutoEntity atualizarProduto (ProdutoEntity produto, Long id) {
		return produtoRepository.findById(id).map(p -> {
			p.setNome(produto.getNome());
			return produtoRepository.save(p);
		}).orElseThrow(() -> new RuntimeException("produto nao encontrado"));
	}


	public void delete(Long id) {
		Optional<ProdutoEntity> produto = produtoRepository.findById(id);
		if (produto.isPresent()) {
			produto.get().setHabilitado(false);
		} else {
			throw new IllegalArgumentException("Produto nao encontrado");
		}
	}
}
