package br.com.academiafit.service;

import java.util.List;

import br.com.academiafit.vo.UsuarioVO;


public interface UsuarioService {
	
	public void salvar(UsuarioVO usuario);
	public void excluir(UsuarioVO usuario);
	public void alterarSenha(UsuarioVO usuario);
	public void consultar(UsuarioVO usuario);
	public List<UsuarioVO> listarTodos();
}
