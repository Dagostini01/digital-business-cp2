package checkpoint.services;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import checkpoint.entities.ProdutoEntity;
import checkpoint.exception.EntidadeNaoEncontradaException;
import checkpoint.repositories.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;

	public List<ProdutoEntity> getProduts() {
		return produtoRepository.findAll();
	}
	
	public ProdutoEntity save(ProdutoEntity produto) {
		return produtoRepository.save(produto);
	}
	
	public ProdutoEntity search(Long id) {
		return produtoRepository.findById(id).orElseThrow(() -> new EntidadeNaoEncontradaException("Produto não encontrado"));
	}
	
	public ProdutoEntity update(Long id, ProdutoEntity produto) {
		ProdutoEntity produtoEx = search(id);
		BeanUtils.copyProperties(produto, produtoEx, "id");
		return produtoRepository.save(produtoEx);
	}
	
	public void deletar(Long id) {
		produtoRepository.delete(search(id));
	}

}
