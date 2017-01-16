package br.com.academia.service;

import java.util.List;

import br.com.academia.vo.ClienteVO;

/**
 * Interface de negócio referente a entidade Cliente
 * @author MARCOS
 *
 */
public interface ClienteService {
	
	public void salvarCliente(ClienteVO clienteVO);
	public List<ClienteVO> listarTodosClientes();
	public void alterarCliente(ClienteVO clienteVO);
	public void excluirCliente(long id);
	public ClienteVO consultarClientePorId(long id);
		

}
