package br.com.academiafit.dao;

import java.util.List;


import br.com.academiafit.entidade.Funcionario;


public interface FuncionarioDAO {

		
		public String incluir(Funcionario funcionario);
		public String alterar(Funcionario funcionario);
		public String excluir (Funcionario funcionario);
		public List<Funcionario> listarTodos();
		

}