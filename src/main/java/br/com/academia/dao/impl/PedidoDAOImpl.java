package br.com.academia.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.academia.dao.PedidoDAO;
import br.com.academia.entidade.Pedido;

@Repository
public class PedidoDAOImpl extends AbstractDAO implements PedidoDAO{

	@Override
	public void salvarPedido(Pedido pedido) {
		this.getEntityManager().persist(pedido);
		
	}

	@Override
	public void excluirPedido(long id) {
		Pedido pedido = this.getEntityManager().find(Pedido.class,id);
		this.getEntityManager().remove(pedido);
		
	}

	@Override
	public Pedido consultarPedidoPorId(long id) {
		Query query = super.getEntityManager().createQuery("select ped from Pedido ped where ped.id = : id");
		query.setParameter("id", id);
		Pedido pedidoConsultado = (Pedido) query.getSingleResult();
		getEntityManager().close();
		return pedidoConsultado;
	}

	@Override
	public List<Pedido> consultarTodosPedidos() {
		Query query = super.getEntityManager().createQuery("select ped from Pedido ped");
		List<Pedido> listPedido = query.getResultList();
		getEntityManager().close();
		return listPedido;
	}

	

}
