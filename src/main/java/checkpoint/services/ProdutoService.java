package checkpoint.services;

import java.util.List;

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

}
