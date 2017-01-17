package br.com.academiafit.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.academiafit.service.UsuarioService;
import br.com.academiafit.vo.UsuarioVO;

@Controller("usuarioMbean")
@Scope("session")
public class UsuarioController {

	private UsuarioService usuarioService;
	private List<UsuarioVO> listaUsuarioVO;
	private UsuarioVO usuario = new UsuarioVO();
	
	@Autowired
	public UsuarioController(UsuarioService usuarioService){
		this.usuarioService = usuarioService;
	}
	
	@PostConstruct
	public void init(){
		//listaUsuarioVO = usuarioService.listarTodos();
		System.out.println(listaUsuarioVO);
	}

	public UsuarioVO getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioVO usuario) {
		this.usuario = usuario;
	}
	

	public List<UsuarioVO> getListaUsuarioVO() {
		return listaUsuarioVO;
	}
	
	/*private void limparCampos(){
		this.usuario.setNickname(null);
		this.usuario.setSenha(null);
	}*/
	
	public String cancelar(){
		return "";
	}
	
	public String salvar(){
		usuarioService.salvar(usuario);		
		return "";
	}
	
	public String excluir(){
		usuarioService.excluir(usuario);
		return "";
	}
	
	public String consultar(){
		usuarioService.consultar(usuario);
		return "";
	}
	
	public String alterarSenha(){
		usuarioService.alterarSenha(usuario);
		return "";
	}
}