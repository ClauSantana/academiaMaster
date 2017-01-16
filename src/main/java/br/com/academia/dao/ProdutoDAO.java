package br.com.academia.dao;

import java.util.List;

import br.com.academia.entidade.Produto;

public interface ProdutoDAO {
	
	public void salvarProduto(Produto produto);
	public void excluirProduto(long id);
	public void alterarProduto(Produto produto);
	public Produto consultarProdutoPorId(long id);
	public List<Produto> consultarTodosPodutos();

}
