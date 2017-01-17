package br.com.academiafit.controller;

import java.util.List;

import br.com.academiafit.service.ClienteService;
import br.com.academiafit.vo.ClienteVO;

//@Controller("ClienteMbean");
//@Scope("session");
public class ClienteController {
	private ClienteService clienteService;
	private List<ClienteVO> listaClienteVO;	
}
