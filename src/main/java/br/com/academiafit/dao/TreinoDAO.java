package br.com.academiafit.dao;

import java.util.List;

import br.com.academiafit.entidade.Treino;


public interface TreinoDAO {

		public void salvar(Treino treino);
		public String incluir(Treino treino);
		public String alterar(Treino treino);
		public String excluir (int index);
		public List<Treino> consultarTodos();
		public List<Treino> listarTodos();

}