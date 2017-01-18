package br.com.academiafit.service.impl;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.academiafit.dao.UsuarioDAO;
import br.com.academiafit.exception.BusinessException;
import br.com.academiafit.service.UsuarioService;
import br.com.academiafit.vo.UsuarioVO;
import br.com.academiafit.vo.converter.ConverterUsuario;

@Service
public class UsuarioServiceImpl implements UsuarioService{
	
	@Autowired(required=true)
	private UsuarioDAO dao;
	
	@Override
	@Transactional
	public void incluir(UsuarioVO usuario) {
		String msg = new String (dao.incluir(ConverterUsuario.ConverterUsuarioVoParaUsuario(usuario)));
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(msg));	
	}

	@Transactional
	public List<UsuarioVO> consultarTodos() {
		return ConverterUsuario.ConverterUsuarioListaUsuarioParaListaVo(dao.consultarTodos());
	}

	@Override
	@Transactional
	public void excluir(UsuarioVO usuario) {
		String msg = new String (dao.excluir(ConverterUsuario.ConverterUsuarioVoParaUsuario(usuario).getNickname()));
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(msg));
	}
	
	@Override
	@Transactional
	public void alterarSenha(UsuarioVO usuario) {
		String msg = new String (dao.alterarSenha(ConverterUsuario.ConverterUsuarioVoParaUsuario(usuario)));
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(msg));
	}

	@Override
	public void consultar(UsuarioVO usuario) {
		try{
			dao.consultar(ConverterUsuario.ConverterUsuarioVoParaUsuario(usuario).getNickname());
		}catch(BusinessException exception){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(exception.getMessage()));
		}
	}

}
