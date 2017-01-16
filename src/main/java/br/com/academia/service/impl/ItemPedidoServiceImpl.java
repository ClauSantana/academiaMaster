package br.com.academia.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.academia.dao.ItemPedidoDAO;
import br.com.academia.entidade.ItemPedido;
import br.com.academia.service.ItemPedidoService;
import br.com.academia.vo.ItemPedidoVO;
import br.com.academia.vo.converter.Converter;

@Service
public class ItemPedidoServiceImpl implements ItemPedidoService{

	@Autowired(required=true)
	private ItemPedidoDAO dao;
	
	@Override
	@Transactional
	public void salvarItemPedido(List<ItemPedidoVO> listaItemPedidoVO) {
		List<ItemPedido> listaItemPedido = 
				Converter.converterListaItemPedidoVoParaItemPedido(listaItemPedidoVO);
		dao.salvarItemPedido(listaItemPedido);
		
	}

}
