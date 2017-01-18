package br.com.academiafit.dao;

import java.util.List;
import br.com.academiafit.entidade.Treino;
import br.com.academiafit.exception.BusinessException;

public interface TreinoDAO {		
	public String incluir(Treino treino);
	public String excluir (long index);
	public String alterar(Treino treino);
	public Treino consultar (long index) throws BusinessException;
	public List<Treino> consultarTodos();
}