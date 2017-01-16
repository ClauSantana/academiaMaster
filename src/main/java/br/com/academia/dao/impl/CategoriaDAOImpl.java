package br.com.academia.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.academia.dao.CategoriaDAO;
import br.com.academia.entidade.Categoria;

@Repository
public class CategoriaDAOImpl extends AbstractDAO implements CategoriaDAO{

	@Override
	public void salvarCategoria(Categoria categoria) {
		this.getEntityManager().persist(categoria);
		
	}

	@Override
	public List<Categoria> listarTodasCategorias() {
		Query query = super.getEntityManager().createQuery("select cat from Categoria cat");
		List<Categoria> listaCategoria = query.getResultList();
		getEntityManager().close();
		return listaCategoria;
	}

	@Override
	public void excluirCategoria(long id){
		
		Categoria categoria = getEntityManager().find(Categoria.class, id);
		this.getEntityManager().remove(categoria);
		
	}

	@Override
	public void alterarCategoria(Categoria categoria) {
		this.getEntityManager().merge(categoria);
		
	}

	@Override
	public Categoria consultarCategoriaPorId(long id) {
		Query query = super.getEntityManager().createQuery("select cat from Categoria cat where categ.id = : id");
		query.setParameter("id", id);
		Categoria categoriaConsultada = (Categoria) query.getSingleResult();
		getEntityManager().close();
		return categoriaConsultada;
	}

	

}
