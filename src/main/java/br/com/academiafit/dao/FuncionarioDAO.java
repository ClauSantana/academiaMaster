package br.com.academiafit.dao;

import java.util.List;


import br.com.academiafit.entidade.Funcionario;


public interface FuncionarioDAO {

		
		public String incluir(Funcionario funcionario);
		public String alterar(Funcionario funcionario);
		public String excluir (int index);
		public List<Funcionario> listarTodos();
		

}