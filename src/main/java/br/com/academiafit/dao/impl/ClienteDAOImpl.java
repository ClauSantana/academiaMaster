package br.com.academiafit.dao.impl;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.Query;

import br.com.academiafit.dao.ClienteDAO;
import br.com.academiafit.entidade.Cliente;
import br.com.academiafit.entidade.Usuario;

public class ClienteDAOImpl extends AbstractDAOImpl implements ClienteDAO{

	@Override
	public String incluir(Cliente cliente) {
		this.getEntityManager().persist(cliente);
		
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Cliente inserido com Sucesso!"));
		
		return " ";
	}

	@Override
	public String alterar(Cliente cliente) {
		
		Query query = super.getEntityManager().createQuery("update Cliente af set af.altura = :altura, af.peso = :peso, af.datacadastro = :datacadastro, af.desenvolvimento = :desenvolvimento where af.id = :id", Usuario.class);

		query.setParameter("altura", cliente.getAltura());
		query.setParameter("peso", cliente.getPeso());
		query.setParameter("datacadastro", cliente.getDatacadastro()); 
		query.setParameter("desenvolvimento", cliente.getDesenvolvimento()); 
		
		query.executeUpdate();

		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Dados alterados com sucesso"));	

		return null;
	}

	@Override
	public List<Cliente> listarTodos() {
		
		Query query = super.getEntityManager().createQuery("select af from Cliente af");

		List<Cliente> listaCliente = query.getResultList();

		super.getEntityManager().close();
		return listaCliente;
	}

	@Override
	public String excluir(Cliente cliente) {
		
		super.getEntityManager().remove(cliente);
		
		return null;
	}

}
