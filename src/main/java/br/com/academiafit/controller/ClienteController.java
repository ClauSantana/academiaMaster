package br.com.academiafit.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.academiafit.service.ClienteService;
import br.com.academiafit.vo.ClienteVO;


//@SessionScoped
//@ManagedBean
public class ClienteController {
	private ClienteService clienteService;
	private List<ClienteVO> listaClienteVO;	
}
