package br.com.academiafit.dao;

import java.util.List;

import br.com.academiafit.entidade.Usuario;

public interface UsuarioDAO {
	public void salvar(Usuario usuario);
	public void excluir(String nickname);
	public void alterarSenha (Usuario usuario);
	public void consultar(String nickname);
	public List<Usuario> listarTodos();
}