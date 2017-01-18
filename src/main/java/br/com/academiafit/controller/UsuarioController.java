package br.com.academiafit.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.academiafit.service.UsuarioService;
import br.com.academiafit.vo.UsuarioVO;



@ManagedBean(name = "usuarioMbean" )
@SessionScoped
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
		//System.out.println(listaUsuarioVO);
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
	
	public String cancelar(){
		return "";
	}
	
	public String incluir(){
		usuarioService.incluir(usuario);		
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
	
	/*private void limparCampos(){
	this.usuario.setNickname(null);
	this.usuario.setSenha(null);
	}*/

}