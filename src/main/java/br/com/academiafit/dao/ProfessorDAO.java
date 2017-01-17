package br.com.academiafit.dao;

import java.util.List;


import br.com.academiafit.entidade.Professor;


public interface ProfessorDAO {

		public void salvar(Professor professor);
		public String incluir(Professor professor);
		public String alterar(Professor professor);
		public String excluir (int index);
		public List<Professor> consultarTodos();
		public List<Professor> listarTodos();

}