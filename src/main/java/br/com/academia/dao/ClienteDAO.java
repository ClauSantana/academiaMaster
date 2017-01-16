package br.com.academia.dao;

import java.util.List;

import br.com.academia.entidade.Cliente;


public interface ClienteDAO {

	public void salvarCliente(Cliente cliente);
	public List<Cliente> listarTodosClientes();
	public void excluirCliente(long id);
	public void alterarCliente(Cliente cliente);
	public Cliente consultarClientePorId(long id);
}
