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

			return "Erro: ID já está sendo utilizado!";

		}catch(BusinessException exception){			
			// incluí a avaliacao física correspondente
			super.getEntityManager().persist(avaliacaofisica);

			// fecha a conexão
			super.getEntityManager().close();

			return "Avaliação Física inserida com sucesso!";

		}
	}

	@Override
	public String excluir(long index){
		try {
			// encontra o usuario com o nickname fornecido, no banco de dados
			AvaliacaoFisica avaliacao = this.consultar(index);

			// exclui o usuario correspondente
			super.getEntityManager().remove(avaliacao);

			// fecha a conexão
			super.getEntityManager().close();

			return "Avaliação Física excluída com sucesso!";

		}catch(BusinessException exception){
			return "Erro: Avaliação não encontrada!";			
		}
	}	

	@Override
	public String alterar (AvaliacaoFisica avaliacaofisica) {
		try{

			// encontra o usuario com o nickname fornecido, no banco de dados
			this.consultar(avaliacaofisica.getId());

			// cria uma query de atualização para a senha do usuário
			Query query = super.getEntityManager().createQuery("update AvaliacaoFisica af set af.dataavaliacao = :dataavaliacao, af.altura = :altura, af.peso = :peso, af.imc = :imc, af.peito = :peito, af.cintura = :cintura, af.quadril = :quadril, af.bracodireito = :bracodireito,af.bracoesquerdo = :bracoesquerdo, af.coxadireito = :coxadireito, af.coxaesquerdo = :coxaesquerdo, af.panturrilhadireito = :panturrilhadireito, af.panturrilhaesquerdo = :panturrilhaesquerdo where af.id = :id", AvaliacaoFisica.class);

			// determina os parâmetros da query
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
			return "Erro: Avaliação Física não encontrado!";
		}
	}

	@Override
	public AvaliacaoFisica consultar(long index) throws BusinessException {
		// encontra o usuario no banco de dados
		AvaliacaoFisica avaliacao = super.getEntityManager().find(AvaliacaoFisica.class, index);

		// fecha a conexão
		super.getEntityManager().close();

		// verifica se o usuario existe no banco de dados
		boolean status = (avaliacao != null);

		if (status){
			// se exisir, gera exceção
			return avaliacao;
		}
		else{
			// se não existir, gera exceção
			throw new BusinessException("Erro: Usuario não existe!");			
		}
	}

	@Override
	public List<AvaliacaoFisica> consultarTodos() {		
		// cria uma query com o select na tabela
		Query query = super.getEntityManager().createQuery("select af from AvaliacaoFisica af");

		// armazena o resultado da busca numa collection
		List<AvaliacaoFisica> listaAvaliacao = query.getResultList();

		// fecha a conexão
		super.getEntityManager().close();

		return listaAvaliacao;
	}
}
