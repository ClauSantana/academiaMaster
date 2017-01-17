package br.com.academiafit.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.academiafit.dao.UsuarioDAO;
import br.com.academiafit.service.UsuarioService;
import br.com.academiafit.vo.UsuarioVO;
import br.com.academiafit.vo.converter.ConverterUsuario;

@Service
public class UsuarioServiceImpl implements UsuarioService{
	
	@Autowired(required=true)
	private UsuarioDAO dao;
	
	@Transactional
	public void salvar(UsuarioVO usuario) {
		dao.salvar(ConverterUsuario.ConverterUsuarioVoParaUsuario(usuario));
	
	}

	@Override
	public List<UsuarioVO> listarTodos() {
		return ConverterUsuario.ConverterUsuarioListaUsuarioParaListaVo(dao.listarTodos());
	}

	@Transactional
	public void excluir(UsuarioVO usuario) {
		dao.excluir(ConverterUsuario.ConverterUsuarioVoParaUsuario(usuario).getNickname());
		
	}

	@Transactional
	public void alterarSenha(UsuarioVO usuario) {
		dao.alterarSenha(ConverterUsuario.ConverterUsuarioVoParaUsuario(usuario));		
	}

	@Transactional
	public void consultar(UsuarioVO usuario) {
		dao.consultar(ConverterUsuario.ConverterUsuarioVoParaUsuario(usuario).getNickname());
	}

}
