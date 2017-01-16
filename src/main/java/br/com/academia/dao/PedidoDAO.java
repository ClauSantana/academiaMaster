package br.com.academia.dao;

import java.util.List;

import br.com.academia.entidade.Pedido;

/**
 * Interface responsável pelas operações de banco de dados da entidade Pedido
 * @author MARCOS
 *
 */
public interface PedidoDAO {

	public void salvarPedido(Pedido pedido);
	public void excluirPedido(long id);
	public Pedido consultarPedidoPorId(long id);
	public List<Pedido> consultarTodosPedidos();
}
