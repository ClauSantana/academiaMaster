package br.com.academia.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.academia.dao.ItemPedidoDAO;
import br.com.academia.entidade.ItemPedido;

@Repository
public class ItemPedidoDAOImpl extends AbstractDAO implements ItemPedidoDAO{

	@Override
	public void salvarItemPedido(List<ItemPedido> listaItemPedido) {

		if(listaItemPedido != null && !listaItemPedido.isEmpty()){
			for(ItemPedido itemPedido : listaItemPedido){
				this.getEntityManager().persist(itemPedido);
			}
		}
		
	}

}
