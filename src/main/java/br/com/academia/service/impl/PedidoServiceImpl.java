package br.com.academia.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.academia.dao.PedidoDAO;
import br.com.academia.entidade.Pedido;
import br.com.academia.service.PedidoService;
import br.com.academia.vo.PedidoVO;
import br.com.academia.vo.converter.Converter;

public class PedidoServiceImpl implements PedidoService{

	@Autowired(required=true)
	private PedidoDAO dao;
	
	@Override
	@Transactional
	public void salvarPedido(PedidoVO pedidoVO) {
		Pedido pedido = Converter.converterVOParaPedido(pedidoVO);
		dao.salvarPedido(pedido);
		
	}

	@Override
	@Transactional
	public void excluirPedido(long id) {
		dao.excluirPedido(id);
		
	}

	@Override
	public List<PedidoVO> consultarTodosPedidos() {
		List<Pedido> listaPedido = dao.consultarTodosPedidos();
		return Converter.converterListaPedidoParaListaPedidoVO(listaPedido);
	}

	@Override
	public PedidoVO consultarPedidoPorId(long id) {
		Pedido pedido = dao.consultarPedidoPorId(id);
		return Converter.converterPedidoParaVO(pedido);
	}
	
}
