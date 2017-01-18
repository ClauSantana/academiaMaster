package br.com.academiafit.dao;

import java.util.List;
import br.com.academiafit.entidade.AvaliacaoFisica;
import br.com.academiafit.exception.BusinessException;

public interface AvaliacaoFisicaDAO {
	public String incluir(AvaliacaoFisica avaliacaofisica);
	public String excluir (long index);
	public String alterar(AvaliacaoFisica avaliacaofisica);
	public AvaliacaoFisica consultar(long index) throws BusinessException;
	public List<AvaliacaoFisica> consultarTodos();
}