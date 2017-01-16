package br.com.academia.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.academia.dao.ClienteDAO;
import br.com.academia.entidade.Cliente;

@Repository
public class ClienteDAOImpl extends AbstractDAO implements ClienteDAO{

	@Override
	public void salvarCliente(Cliente cliente) {
		this.getEntityManager().persist(cliente);
		
	}

	@Override
	public List<Cliente> listarTodosClientes() {
		Query query = super.getEntityManager().createQuery("select c from Cliente c");
		List<Cliente> listaCliente = query.getResultList();
		getEntityManager().close();
		return listaCliente;
	}

	@Override
	public void excluirCliente(long id) {
		Cliente cliente = this.getEntityManager().find(Cliente.class, id);
		this.getEntityManager().remove(cliente);
	}

	@Override
	public void alterarCliente(Cliente cliente) {
		this.getEntityManager().merge(cliente);
		
	}

	@Override
	public Cliente consultarClientePorId(long id) {
		Query query = super.getEntityManager().createQuery("select c from Cliente c where c.id = : id");
		query.setParameter("id", id);
		Cliente clienteConsultado = (Cliente) query.getSingleResult();
		getEntityManager().close();
		return clienteConsultado;
	}
	
	
	
	

}
