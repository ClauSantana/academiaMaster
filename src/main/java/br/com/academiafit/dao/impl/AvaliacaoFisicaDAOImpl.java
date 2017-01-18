package br.com.academiafit.dao.impl;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.academiafit.dao.AvaliacaoFisicaDAO;
import br.com.academiafit.entidade.AvaliacaoFisica;
import br.com.academiafit.exception.BusinessException;

@Repository
public class AvaliacaoFisicaDAOImpl extends AbstractDAO implements AvaliacaoFisicaDAO{

	@Override
	public String incluir(AvaliacaoFisica avaliacaofisica) {	
		try {
			// encontra o usuario com o nickname fornecido, no banco de dados
			this.consultar(avaliacaofisica.getId());

			return "Erro: ID j� est� sendo utilizado!";

		}catch(BusinessException exception){			
			// inclu� a avaliacao f�sica correspondente
			super.getEntityManager().persist(avaliacaofisica);

			// fecha a conex�o
			super.getEntityManager().close();

			return "Avalia��o F�sica inserida com sucesso!";

		}
	}

	@Override
	public String excluir(long index){
		try {
			// encontra o usuario com o nickname fornecido, no banco de dados
			AvaliacaoFisica avaliacao = this.consultar(index);

			// exclui o usuario correspondente
			super.getEntityManager().remove(avaliacao);

			// fecha a conex�o
			super.getEntityManager().close();

			return "Avalia��o F�sica exclu�da com sucesso!";

		}catch(BusinessException exception){
			return "Erro: Avalia��o n�o encontrada!";			
		}
	}	

	@Override
	public String alterar (AvaliacaoFisica avaliacaofisica) {
		try{

			// encontra o usuario com o nickname fornecido, no banco de dados
			this.consultar(avaliacaofisica.getId());

			// cria uma query de atualiza��o para a senha do usu�rio
			Query query = super.getEntityManager().createQuery("update AvaliacaoFisica af set af.dataavaliacao = :dataavaliacao, af.altura = :altura, af.peso = :peso, af.imc = :imc, af.peito = :peito, af.cintura = :cintura, af.quadril = :quadril, af.bracodireito = :bracodireito,af.bracoesquerdo = :bracoesquerdo, af.coxadireito = :coxadireito, af.coxaesquerdo = :coxaesquerdo, af.panturrilhadireito = :panturrilhadireito, af.panturrilhaesquerdo = :panturrilhaesquerdo where af.id = :id", AvaliacaoFisica.class);

			// determina os par�metros da query
			query.setParameter("dataavaliacao", avaliacaofisica.getDataavaliacao());
			query.setParameter("altura", avaliacaofisica.getAltura());
			query.setParameter("peso", avaliacaofisica.getPeso());
			query.setParameter("imc", avaliacaofisica.getImc()); 
			query.setParameter("peito", avaliacaofisica.getPeito()); 
			query.setParameter("cintura", avaliacaofisica.getCintura()); 
			query.setParameter("quadril", avaliacaofisica.getQuadril()); 
			query.setParameter("bracodireito", avaliacaofisica.getBracoDireito());
			query.setParameter("bracoesquerdo", avaliacaofisica.getBracoEsquerdo());
			query.setParameter("coxadireito", avaliacaofisica.getCoxaDireito());
			query.setParameter("coxaesquerdo", avaliacaofisica.getCoxaEsquerdo()); 
			query.setParameter("panturrilhadireito", avaliacaofisica.getPanturrilhaDireito());
			query.setParameter("panturrilhaesquerdo", avaliacaofisica.getPanturrilhaEsquerdo());

			// executa a query
			query.executeUpdate();

			return "Dados alterados com sucesso";	

		}catch(BusinessException exception){			
			return "Erro: Avalia��o F�sica n�o encontrado!";
		}
	}

	@Override
	public AvaliacaoFisica consultar(long index) throws BusinessException {
		// encontra o usuario no banco de dados
		AvaliacaoFisica avaliacao = super.getEntityManager().find(AvaliacaoFisica.class, index);

		// fecha a conex�o
		super.getEntityManager().close();

		// verifica se o usuario existe no banco de dados
		boolean status = (avaliacao != null);

		if (status){
			// se exisir, gera exce��o
			return avaliacao;
		}
		else{
			// se n�o existir, gera exce��o
			throw new BusinessException("Erro: Usuario n�o existe!");			
		}
	}

	@Override
	public List<AvaliacaoFisica> consultarTodos() {		
		// cria uma query com o select na tabela
		Query query = super.getEntityManager().createQuery("select af from AvaliacaoFisica af");

		// armazena o resultado da busca numa collection
		List<AvaliacaoFisica> listaAvaliacao = query.getResultList();

		// fecha a conex�o
		super.getEntityManager().close();

		return listaAvaliacao;
	}
}
