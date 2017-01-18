package br.com.academiafit.dao.impl;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.academiafit.dao.UsuarioDAO;
import br.com.academiafit.entidade.Usuario;
import br.com.academiafit.exception.BusinessException;

@Repository
public class UsuarioDAOImpl extends AbstractDAO implements UsuarioDAO{

	// Salvar: salva o novo usuário no banco de dados
	@Override
	public String incluir(Usuario usuario){
		try {
			// encontra o usuario com o nickname fornecido, no banco de dados
			this.consultar(usuario.getNickname());

			return "Erro: Nickname já está sendo utilizado!";

		}catch(BusinessException exception){			
			// incluí o usuario correspondente
			super.getEntityManager().persist(usuario);

			// fecha a conexão
			super.getEntityManager().close();

			return "Usuario inserido com sucesso!";

		}
	}

	// excluir: exclui um usuário do banco
	@Override
	public String excluir(String nickname){
		try {
			// encontra o usuario com o nickname fornecido, no banco de dados
			Usuario usuarioExcluir = this.consultar(nickname);

			// exclui o usuario correspondente
			super.getEntityManager().remove(usuarioExcluir);

			// fecha a conexão
			super.getEntityManager().close();

			return "Usuario excluído com sucesso!";

		}catch(BusinessException exception){
			return "Erro: Usuario não encontrado!";			
		}		
	}

	// alterarSenha: altera a senha de um determinado usuário
	@Override
	public String alterarSenha(Usuario usuario){
		try{

			// encontra o usuario com o nickname fornecido, no banco de dados
			this.consultar(usuario.getNickname());
			
			// cria uma query de atualização para a senha do usuário
			Query query = super.getEntityManager().createQuery("update Usuario u set u.senha = :senha where u.nickname like :nickname", Usuario.class);

			// determina os parâmetros da query
			query.setParameter("nickname", usuario.getNickname());
			query.setParameter("senha", usuario.getSenha());

			// executa a query
			query.executeUpdate();
			
			// fecha a conexão
			super.getEntityManager().close();

			return "Senha alterada com sucesso!";

		}catch(BusinessException exception){			
			return "Erro: Usuario não encontrado!";
		}
	}

	@Override
	public Usuario consultar(String nickname) throws BusinessException{
		// encontra o usuario no banco de dados
		Usuario usuario = super.getEntityManager().find(Usuario.class, nickname);

		// fecha a conexão
		super.getEntityManager().close();

		// verifica se o usuario existe no banco de dados
		boolean status = (usuario != null);

		if (status){
			// se exisir, gera exceção
			return usuario;
		}
		else{
			// se não existir, gera exceção
			throw new BusinessException("Erro: Usuario não existe!");			
		}
	}

	// listarTodos: obtém todos os Usuarios a partir do banco
	@Override
	public List<Usuario> consultarTodos(){
		// cria uma query com o select na tabela usuario
		Query query = super.getEntityManager().createQuery("select u from Usuario u");

		// armazena o resultado da busca numa collection de usuários
		List<Usuario> listaUsuario = query.getResultList();

		// fecha a conexão
		super.getEntityManager().close();

		return listaUsuario;
	}
}
