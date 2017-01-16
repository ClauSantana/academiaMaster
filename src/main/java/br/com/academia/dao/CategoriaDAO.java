package br.com.academia.dao;

import java.util.List;

import br.com.academia.entidade.Categoria;

/**
 * Interface de DAO para acesso a operações de banco de dados da entidade Categoria
 * @author MARCOS
 *
 */
public interface CategoriaDAO {
	
	public void salvarCategoria(Categoria categoria);
	public List<Categoria> listarTodasCategorias();
	public void excluirCategoria(long id);
	public void alterarCategoria(Categoria categoria);
	public Categoria consultarCategoriaPorId(long id);

}
