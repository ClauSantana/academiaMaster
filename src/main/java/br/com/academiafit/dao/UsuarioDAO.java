package br.com.academiafit.dao;

import java.util.List;
import br.com.academiafit.entidade.Usuario;
import br.com.academiafit.exception.BusinessException;

public interface UsuarioDAO {
	public String incluir(Usuario usuario);
	public String excluir(String nickname);
	public String alterarSenha (Usuario usuario);
	public Usuario consultar(String nickname) throws BusinessException;
	public List<Usuario> consultarTodos();
}