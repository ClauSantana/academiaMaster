package br.com.academiafit.dao.impl;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.academiafit.dao.TreinoDAO;
import br.com.academiafit.entidade.Treino;
import br.com.academiafit.exception.BusinessException;

@Repository
public class TreinoDAOImpl extends AbstractDAO implements TreinoDAO{

	@Override
	public String incluir(Treino treino){
		try {
			// encontra o usuario com o nickname fornecido, no banco de dados
			this.consultar(treino.getId());

			return "Erro: ID j� est� sendo utilizado!";

		}catch(BusinessException exception){			
			// inclu� a avaliacao f�sica correspondente
			super.getEntityManager().persist(treino);

			// fecha a conex�o
			super.getEntityManager().close();

			return "Treino inserido com sucesso!";

		}		
	}

	@Override
	public String excluir(long index) {
		try {
			// encontra o usuario com o nickname fornecido, no banco de dados
			Treino treino = this.consultar(index);

			// exclui o usuario correspondente
			super.getEntityManager().remove(treino);

			// fecha a conex�o
			super.getEntityManager().close();

			return "Treino exclu�do com sucesso!";

		}catch(BusinessException exception){
			return "Erro: Treino n�o encontrado!";			
		}
	}

	@Override
	public String alterar(Treino treino) {
		try{

			// encontra o usuario com o nickname fornecido, no banco de dados
			this.consultar(treino.getId());
			Query query = super.getEntityManager().createQuery("update Treino t set t.diasemana = :diasemana, t.series = :series, t.repeticoes = :repeticoes where t.id = :id", Treino.class);

			// determina os par�metros da query
			query.setParameter("diasemana", treino.getDiasemana());
			query.setParameter("series", treino.getSeries());
			query.setParameter("repeticoes", treino.getRepeticoes());

			// executa a query
			query.executeUpdate();

			return "Dados alterados com sucesso";	

		}catch(BusinessException exception){			
			return "Erro: Treino n�o encontrado!";
		}
	}

	@Override
	public Treino consultar(long index) throws BusinessException {
		// encontra o usuario no banco de dados
		Treino treino = super.getEntityManager().find(Treino.class, index);

		// fecha a conex�o
		super.getEntityManager().close();

		// verifica se o usuario existe no banco de dados
		boolean status = (treino != null);

		if (status){
			// se exisir, gera exce��o
			return treino;
		}
		else{
			// se n�o existir, gera exce��o
			throw new BusinessException("Erro: Usuario n�o existe!");			
		}
	}

	@Override
	public List<Treino> consultarTodos() {
		// cria uma query com o select na tabela
		Query query = super.getEntityManager().createQuery("select t from Treino t");

		// armazena o resultado da busca numa collection
		List<Treino> listaTreino = query.getResultList();

		// fecha a conex�o
		super.getEntityManager().close();

		return listaTreino;
	}

}
