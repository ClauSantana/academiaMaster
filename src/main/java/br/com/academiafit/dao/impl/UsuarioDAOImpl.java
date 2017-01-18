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

	// Salvar: salva o novo usu�rio no banco de dados
	@Override
	public String incluir(Usuario usuario){
		try {
			// encontra o usuario com o nickname fornecido, no banco de dados
			this.consultar(usuario.getNickname());

			return "Erro: Nickname j� est� sendo utilizado!";

		}catch(BusinessException exception){			
			// inclu� o usuario correspondente
			super.getEntityManager().persist(usuario);

			// fecha a conex�o
			super.getEntityManager().close();

			return "Usuario inserido com sucesso!";

		}
	}

	// excluir: exclui um usu�rio do banco
	@Override
	public String excluir(String nickname){
		try {
			// encontra o usuario com o nickname fornecido, no banco de dados
			Usuario usuarioExcluir = this.consultar(nickname);

			// exclui o usuario correspondente
			super.getEntityManager().remove(usuarioExcluir);

			// fecha a conex�o
			super.getEntityManager().close();

			return "Usuario exclu�do com sucesso!";

		}catch(BusinessException exception){
			return "Erro: Usuario n�o encontrado!";			
		}		
	}

	// alterarSenha: altera a senha de um determinado usu�rio
	@Override
	public String alterarSenha(Usuario usuario){
		try{

			// encontra o usuario com o nickname fornecido, no banco de dados
			this.consultar(usuario.getNickname());
			
			// cria uma query de atualiza��o para a senha do usu�rio
			Query query = super.getEntityManager().createQuery("update Usuario u set u.senha = :senha where u.nickname like :nickname", Usuario.class);

			// determina os par�metros da query
			query.setParameter("nickname", usuario.getNickname());
			query.setParameter("senha", usuario.getSenha());

			// executa a query
			query.executeUpdate();
			
			// fecha a conex�o
			super.getEntityManager().close();

			return "Senha alterada com sucesso!";

		}catch(BusinessException exception){			
			return "Erro: Usuario n�o encontrado!";
		}
	}

	@Override
	public Usuario consultar(String nickname) throws BusinessException{
		// encontra o usuario no banco de dados
		Usuario usuario = super.getEntityManager().find(Usuario.class, nickname);

		// fecha a conex�o
		super.getEntityManager().close();

		// verifica se o usuario existe no banco de dados
		boolean status = (usuario != null);

		if (status){
			// se exisir, gera exce��o
			return usuario;
		}
		else{
			// se n�o existir, gera exce��o
			throw new BusinessException("Erro: Usuario n�o existe!");			
		}
	}

	// listarTodos: obt�m todos os Usuarios a partir do banco
	@Override
	public List<Usuario> consultarTodos(){
		// cria uma query com o select na tabela usuario
		Query query = super.getEntityManager().createQuery("select u from Usuario u");

		// armazena o resultado da busca numa collection de usu�rios
		List<Usuario> listaUsuario = query.getResultList();

		// fecha a conex�o
		super.getEntityManager().close();

		return listaUsuario;
	}
}
