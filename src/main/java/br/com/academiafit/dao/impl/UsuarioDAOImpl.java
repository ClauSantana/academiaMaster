package br.com.academiafit.dao.impl;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.academiafit.dao.UsuarioDAO;
import br.com.academiafit.entidade.Usuario;

@Repository
public class UsuarioDAOImpl extends AbstractDAOImpl implements UsuarioDAO{

	// Salvar: salva o novo usuário no banco de dados
	@Override
	public void salvar(Usuario usuario){
		// verifica se o usuario existe no banco de dados
		if (super.getEntityManager().find(Usuario.class, usuario.getNickname()) != null){

			// se exisir, então não aceita o login colocado
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Login já está sendo utilizado por outro usuário!"));
		}
		else{
			// se não existir, insere no banco
			super.getEntityManager().persist(usuario);

			// mostra alerta de inserção na tela do usuário
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usuario cadastrado com sucesso!"));
		}
	}

	// listarTodos: obtem todos os Usuarios a partir do banco
	@Override
	public List<Usuario> listarTodos(){
		// cria uma query com o select na tabela usuario
		Query query = super.getEntityManager().createQuery("select u from Usuario u");

		// armazena o resultado da busca numa collection de usuários
		List<Usuario> listaUsuario = query.getResultList();

		// fecha a conexão
		super.getEntityManager().close();

		return listaUsuario;
	}

	// excluir: exclui um usuário do banco
	@Override
	public void excluir(String nickname) {
		// verifica se o nickname fornecido existe no banco de dados
		Usuario usuarioExcluir = super.getEntityManager().find(Usuario.class, nickname);

		if (usuarioExcluir != null){ // se existir

			// exclui o usuario correspondente
			super.getEntityManager().remove(usuarioExcluir);

			// imprime alerta na tela
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usuario excluido com sucesso!"));
		}
		else{	// se não existir

			// imprime alerta de usuario não encontrado na tela do usuário
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usuario não encontrado!"));
		}

		// fecha a conexão
		super.getEntityManager().close();
	}

	// alterarSenha: altera a senha de um determinado usuário
	@Override
	public void alterarSenha(Usuario usuario){
		boolean status = (super.getEntityManager().find(Usuario.class, usuario.getNickname()) != null);
		
		if (status){
			// cria uma query de atualização para a senha do usuário
			Query query = super.getEntityManager().createQuery("update Usuario u set u.senha = :senha where u.nickname like :nickname", Usuario.class);
	
			// determina os parâmetros da query
			query.setParameter("nickname", usuario.getNickname());
			query.setParameter("senha", usuario.getSenha());
	
			// executa a query
			query.executeUpdate();
			
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Senha alterada com sucesso"));
		}
		else{
			// usuario não existe
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usuario não encontrado!"));
		}

		// fecha a conexão
		super.getEntityManager().close();
	}

	@Override
	public void consultar(String nickname) {
		// verifica se o nickname fornecido existe no banco de dados
		Usuario usuario = super.getEntityManager().find(Usuario.class, nickname);

		if (usuario != null){ // se existir
			// mostra um alerta na tela do usuário
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Nickname: "+usuario.getNickname() + " Senha: " + usuario.getSenha()));	
		}
		else{
			// mostra um alerta na tela do usuário
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usuario não encontrado."));
		}
		
		// fecha a conexão
		super.getEntityManager().close();
	}	
}
