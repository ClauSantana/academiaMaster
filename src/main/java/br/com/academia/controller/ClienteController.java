package br.com.academia.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.academia.service.ClienteService;
import br.com.academia.vo.ClienteVO;

@ManagedBean(name = "clienteMbean")
@SessionScoped
public class ClienteController extends AbstractController{

	public static String TELA_LISTA_TODOS = "/cliente/listar_todos_clientes.xhtml";
	public static String TELA_CADASTRAR_CLIENTE = "/cliente/cadastrar_cliente.xhtml";
	
	@Autowired
	private ClienteService clienteService;

	private List<ClienteVO> listaClienteVO;

	@PostConstruct
	private void init() {
		super.getConfigSpring();
	}

	private ClienteVO cliente = new ClienteVO();

	public ClienteVO getCliente() {
		return cliente;
	}

	public void setCliente(ClienteVO employee) {
		this.cliente = cliente;
	}

	public String salvar() {
		// Calling Business Service
		clienteService.salvarCliente(cliente);
		// Add message
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO,null,"Cliente gravado com sucesso!"));

		this.limparCampos();
		return "";
	}
	
	public String excluir(ClienteVO clienteVO){
		if(clienteVO != null && clienteVO.getId() != 0){
			this.clienteService.excluirCliente(clienteVO.getId());			
		}
		this.listaClienteVO = clienteService.listarTodosClientes();
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO,null,"Cliente excluido com sucesso!"));
		return "";
	}

	/**
	 * @return the listaClienteVO
	 */
	public List<ClienteVO> getListaClienteVO() {
		return listaClienteVO;
	}

	private void limparCampos() {
		this.getCliente().setCpf(null);
		this.getCliente().setDataNascimento(null);
		this.getCliente().setEmail(null);
		this.getCliente().setNome(null);
	}
	
	public String chamarTelaListarTodosClientes(){
		listaClienteVO = clienteService.listarTodosClientes();
		return TELA_LISTA_TODOS;
	}
	
	public String chamarTelaCadastro(){
		return TELA_CADASTRAR_CLIENTE;
	}

}
