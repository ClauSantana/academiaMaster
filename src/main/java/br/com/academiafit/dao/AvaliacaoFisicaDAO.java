package br.com.academiafit.dao;

import java.util.List;
import br.com.academiafit.entidade.AvaliacaoFisica;


public interface AvaliacaoFisicaDAO {

		public String incluir(AvaliacaoFisica avaliacaofisica);
		public String alterar(AvaliacaoFisica avaliacaofisica);
		public String excluir (int index);
		public List<AvaliacaoFisica> consultarTodos();
}