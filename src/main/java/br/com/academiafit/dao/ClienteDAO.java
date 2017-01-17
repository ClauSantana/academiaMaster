package br.com.academiafit.dao;

import java.util.List;

import br.com.academiafit.entidade.Cliente;


public interface ClienteDAO {

		public void salvar(Cliente cliente);
		public String incluir(Cliente cliente);
		public String excluir (int index);
		public List<Cliente> consultarTodos();
		String excluir(Cliente cliente);
		public List<Cliente> listarTodos();

}