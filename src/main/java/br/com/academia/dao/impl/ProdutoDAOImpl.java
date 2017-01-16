package br.com.academia.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.academia.dao.ProdutoDAO;
import br.com.academia.entidade.Produto;

@Repository
public class ProdutoDAOImpl extends AbstractDAO implements ProdutoDAO{

	@Override
	public void salvarProduto(Produto produto) {
		this.getEntityManager().persist(produto);
		
	}

	@Override
	public void excluirProduto(long id) {
		Produto produto = this.getEntityManager().find(Produto.class, id);
		this.getEntityManager().remove(produto);
		
	}

	@Override
	public void alterarProduto(Produto produto) {
		this.getEntityManager().merge(produto);
		
	}

	@Override
	public Produto consultarProdutoPorId(long id) {
		Query query = super.getEntityManager().createQuery("select p from Produto p where p.id = :id");
		Produto produtoConsultado = (Produto)query.getSingleResult();
		getEntityManager().close();
		return produtoConsultado;
	}

	@Override
	public List<Produto> consultarTodosPodutos() {
		Query query = super.getEntityManager().createQuery("select p from Produto p");
		List<Produto> listaProduto = query.getResultList();
		getEntityManager().close();
		return listaProduto;
	}

	

}
