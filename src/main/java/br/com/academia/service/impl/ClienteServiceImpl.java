package br.com.academia.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.academia.dao.ClienteDAO;
import br.com.academia.entidade.Cliente;
import br.com.academia.service.ClienteService;
import br.com.academia.vo.ClienteVO;
import br.com.academia.vo.converter.Converter;

@Service
public class ClienteServiceImpl implements ClienteService{

	@Autowired(required=true)
	private ClienteDAO dao;

	@Override
	@Transactional
	public void salvarCliente(ClienteVO clienteVO) {
		Cliente cliente = Converter.converterVoParaCliente(clienteVO);
		dao.salvarCliente(cliente);
		
	}

	@Override
	public List<ClienteVO> listarTodosClientes() {
		List<Cliente> listaCliente = dao.listarTodosClientes();
		return Converter.converterListaClienteParaListaVo(listaCliente);
	}

	@Override
	@Transactional
	public void alterarCliente(ClienteVO clienteVO) {
		Cliente cliente = Converter.converterVoParaCliente(clienteVO);
		dao.alterarCliente(cliente);
		
	}

	@Override
	@Transactional
	public void excluirCliente(long id) {
		dao.excluirCliente(id);
		
	}

	@Override
	public ClienteVO consultarClientePorId(long id) {
		Cliente cliente = dao.consultarClientePorId(id);
		return Converter.converterClienteParaVO(cliente);
	}
	

	
}
