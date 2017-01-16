package br.com.academia.service;

import java.util.List;

import br.com.academia.vo.PedidoVO;

public interface PedidoService {
	
	public void salvarPedido(PedidoVO pedidoVO);
	public void excluirPedido(long id);
	public List<PedidoVO> consultarTodosPedidos();
	public PedidoVO consultarPedidoPorId(long id);

}
